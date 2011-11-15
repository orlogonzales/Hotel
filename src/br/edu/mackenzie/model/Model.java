package br.edu.mackenzie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import br.edu.mackenzie.dao.ConnectionFactory;
import br.edu.mackenzie.dao.FieldDb;

import com.mysql.jdbc.Statement;

public abstract class Model {
	
	/**
	 * Conexao com o banco
	 */
	private Connection connection ;
	
	/**
	 * Nome da tabela no banco
	 * Por conven�ao, a tabela deve ter o nome "nome_da_tabela" + "_tb"
	 */
	// TODO Tirar o nome da classe do pacote
	private String tableName = this.getClass().getName().toLowerCase() ;
	
	/**
	 * Lista de campos da tabela usando HashMap
	 */
	private HashMap<String, FieldDb> tableFields = new HashMap<String, FieldDb>() ;
	
	/**
	 * Determina se o registro existe.
	 */
	private boolean _exists = false ;
	
	/**
	 * Retorna o nome da tabela
	 */
	abstract String getTableName() ;

	/**
	 * Popula o atributo tableFields com os campos da tabela
	 * @throws SQLException 
	 */
	private void _populateConfig() throws SQLException {
		Statement stmt = (Statement) this.connection.createStatement() ;
		ResultSet rs = stmt.executeQuery("desc " + this.tableName + "_tb" ) ;
		FieldDb field ;
		
		// Percorrendo os registros encontrados
		while ( rs.next() ){
			field = new FieldDb() ;
			field.setField(rs.getString("field"));
			field.setType(rs.getString("type"));
			field.setNull(rs.getString("null"));
			field.setPrimaryKey(rs.getString("KEY"));
			//System.out.println(rs.getString("field") + "-" + rs.getString("type") + "-" + rs.getString("null") );
			this.tableFields.put( rs.getString("field") , field) ;
		}
		
		rs.close();
		stmt.close();
	}
	
	/**
	 * Obtem um registro passando-se a chave primaria
	 * TODO Tratar SQLException
	 * @param id
	 * @throws SQLException
	 */
	private void _getRegister(int id) throws SQLException{
		String sql = "select * from " + this.tableName + "_tb where " + this.tableName + "_id = ?" ;
		PreparedStatement stmt = this.connection.prepareStatement(sql) ;
		stmt.setInt(1, id) ;
		System.out.println(stmt.toString());
		ResultSet rs = stmt.executeQuery() ;
		Set<String> key_fields = this.tableFields.keySet() ;
		Iterator i = key_fields.iterator();
		FieldDb field ;
		if ( rs.next() ){
			this._exists = true ;
			while ( i.hasNext() ){
				field = (FieldDb) this.tableFields.get(i.next()) ;
				field.setValue(rs.getString(field.getField())) ;
				System.out.println(field.getField() + ": " + rs.getString(field.getField()));
			}
		}
		else {
			this._exists = false ;
		}
		rs.close();
	}
	
	/**
	 * Inicia uma conexao
	 * @author	alissonperez
	 * @throws	SQLException 
	 */
	private void _startConnection() throws SQLException{
		ConnectionFactory factory = ConnectionFactory.getInstance() ;
		this.connection = factory.getConnection() ; 
	}
	
	/**
	 * Retorna o objeto FieldDb
	 * @author	alissonperez
	 * @param	name	Nome do campo que queremos buscar
	 */
	private FieldDb _getField( String name ){
		return this.tableFields.get( name ) ;
	}
	
	/**
	 * Construtor que inicializa a conexao, popula a lista de campos da tabela e obtem o registro
	 * caso o id do campo seja passado
	 * @param id
	 * @throws SQLException
	 */
	public Model(int id) throws SQLException {
		this.tableName = this.getTableName() ;
		this._startConnection() ;
		this._populateConfig();
		
		if (id > 0){
			this._getRegister(id);
		}
	}
	
	/**
	 * Sobrecarga do construtor quando nao se tem id (um novo objeto)
	 * @author	alissonperez
	 */
	public Model() throws SQLException {
		this.tableName = this.getTableName() ;
		this._startConnection() ;
		this._populateConfig() ;
	}
	
	/**
	 * Seta o valor no campo especificado no parametro
	 * @author	alissonperez
	 * @param	name	Nome do campo
	 * @param	value	Valor do campo
	 */
	public boolean set( String name, String value ){
		FieldDb field = this._getField(name) ;
		if ( field != null && ! field.isPrimaryKey() ) {
			field.setValue(value) ;			
			return true ;
		}
		return false ;
	}
	
	/**
	 * Retorna o valor de um campo
	 * @author	alissonperez
	 * @param	name	Nome do campo
	 */
	public String get( String name ) {
		FieldDb field = this._getField(name) ;
		if ( field != null ){
			return field.getValue() ;
		}
		return null ;
	}
	
	/**
	 * Verifica se o registro existe
	 */
	public boolean exists(){
		System.out.println("False: " + this._exists );
		return this._exists ;
	}
	
	/**
	 * Remove o registro do banco
	 * @throws SQLException 
	 */
	public boolean remove() throws SQLException {
		if ( this._exists ) {
			FieldDb primary_key = this._getField( this.tableName + "_id" ) ;
			String sql = "delete from " + this.tableName + "_tb where " + primary_key.getField() + "=" + primary_key.getValue() ;
			Statement stmt = (Statement) this.connection.createStatement();
			//System.out.println(stmt.toString());
			return stmt.execute(sql) ;
		}
		return false;
	}
	
	/**
	 * Salva os dados no banco
	 * @author	alissonperez
	 */
	public boolean save(){
		String sql = "";
		FieldDb field, primaryKey = null ;
		
		// Obtendo as chaves
		Set<String> key_fields = this.tableFields.keySet() ;
		Iterator<String> i = key_fields.iterator();
		
		if ( this._exists ){
			sql += "UPDATE " + this.tableName + "_tb SET " ;
			
			while ( i.hasNext() ){
				field = (FieldDb) this.tableFields.get(i.next()) ;
				if ( field.isPrimaryKey() ){
					primaryKey = field ;
				}
				else {
					sql += field.getField() + " = ?" ;
					if ( i.hasNext() ){
						sql += ", " ;
					}
				}
			}

			sql += " WHERE " + this.tableName + "_id = ?" ; 
		}
		else {
			sql += "INSERT INTO " + this.tableName + "_tb (" ;
			while ( i.hasNext() ){
				field = (FieldDb) this.tableFields.get(i.next()) ;
				if ( ! field.isPrimaryKey() ) {
					sql += field.getField() ;
					if ( i.hasNext() ){
						sql += ", " ;
					}
				}
			}
			
			sql += ") VALUES (" ;
			
			// Resetando o iterador
			i = key_fields.iterator() ;
			
			while ( i.hasNext() ){
				field = (FieldDb) this.tableFields.get(i.next()) ;
				if ( ! field.isPrimaryKey() ){
					sql += "?" ;
					if ( i.hasNext() ){
						sql += "," ;
					}
				}
			}
			
			sql += ")" ;
		}
		
		// Preparando o statement
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS ) ;
			i = key_fields.iterator() ;
			
			// Contador para substituicao dos '?' pelos valores
			int counter = 1 ;
			
			// Percorrendo os valores
			while (i.hasNext()) {
				field = (FieldDb) this.tableFields.get(i.next()) ;
				if ( ! field.isPrimaryKey() ) {
					stmt.setString( counter++ , field.getValue() ) ;
				}
			}
			
			// Preenchendo o valor da chave primaria caso o registro exista
			if ( this._exists && primaryKey != null ) {
				stmt.setString( counter , primaryKey.getValue() ) ;
			}
			
			//Executando a query
			//System.out.println(stmt.toString());
			int execute = stmt.executeUpdate() ;
			
			// Atualizando o valor do id caso o registro ainda nao exista
			if ( ! this._exists && execute > 0 ) {
				ResultSet rs = stmt.getGeneratedKeys() ;
				i = key_fields.iterator() ;
				if ( rs != null && rs.next() ) {
					while ( i.hasNext() ) {
						field = (FieldDb) this.tableFields.get( i.next() ) ;
						if ( field.isPrimaryKey() ) {
							field.setValue(rs.getString(1)) ;
							break ;
						}
					}
				}
				
				this._exists = true ;
			}
			
			return execute > 0;
		} catch (SQLException e){
			return false ;
		}
		
	}
	
}
