package br.edu.mackenzie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
	 * Por convençao, a tabela deve ter o nome "nome_da_tabela" + "_tb"
	 */
	// TODO Tirar o nome da classe do pacote
	private String tableName = this.getClass().getName().toLowerCase() ;
	
	/**
	 * Lista de campos da tabela
	 * @todo	Alterar para HashMap
	 */
	// TODO Alterar para HashMap
	private ArrayList<FieldDb> table_fields = new ArrayList<FieldDb>() ;
	
	/**
	 * Determina se o registro existe.
	 */
	private boolean _exists = false ;

	/**
	 * Popula o atributo table_fields com os campos da tabela
	 * @throws SQLException 
	 */
	private void _populateConfig() throws SQLException {
		Statement stmt = (Statement) this.connection.createStatement() ;
		ResultSet rs = stmt.executeQuery("desc " + this.tableName) ;
		FieldDb field ;
		
		// Percorrendo os registros encontrados
		while ( rs.next() ){
			field = new FieldDb() ;
			field.setField(rs.getString("field"));
			field.setType(rs.getString("type"));
			field.setNull(rs.getString("null"));
			field.setPrimaryKey(rs.getString("KEY"));
			this.table_fields.add(field);
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
		String sql = "select * from ? where ? = ?" ;
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, this.tableName + "_tb" ) ;
		stmt.setString(2, this.tableName + "_id" ) ;
		stmt.setInt(3, id) ;
		ResultSet rs = stmt.executeQuery() ;
		Iterator i = this.table_fields.listIterator();
		FieldDb field ;
		if ( rs.next() ){
			this._exists = true ;
			while ( i.hasNext() ){
				field = (FieldDb) i.next() ;
				field.setValue(rs.getString(field.getField())) ;
			}
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
		Iterator<FieldDb> i = this.table_fields.iterator() ;
		FieldDb field = null ;
		while ( i.hasNext() ){
			field = (FieldDb) i.next() ;
			if ( field.getField().equals(name) ){
				break ;
			}
		}
		return field ;
	}
	
	/**
	 * Construtor que inicializa a conexao, popula a lista de campos da tabela e obtem o registro
	 * caso o id do campo seja passado
	 * @param id
	 * @throws SQLException
	 */
	public Model(int id) throws SQLException {
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
	 * Salva os dados no banco
	 * @author	alissonperez
	 */
	public boolean save(){
		String sql = "";
		FieldDb field, primaryKey = null ;
		Iterator i = this.table_fields.iterator() ;
		
		if ( this._exists ){
			sql += "UPDATE " + this.tableName + " " ;
			
			while ( i.hasNext() ){
				field = (FieldDb) i.next() ;
				if ( field.isPrimaryKey() ){
					primaryKey = field ;
				}
				sql += field.getField() + " = ?" ;
				if ( i.hasNext() ){
					sql += ", " ;
				}
			}

			sql += "where " + this.tableName + "_id = ?" ; 
		}
		else {
			sql += "INSERT " + this.tableName + " (" ;
			while ( i.hasNext() ){
				field = (FieldDb) i.next() ;
				if ( ! field.isPrimaryKey() ) {
					sql += field.getField() ;
					if ( i.hasNext() ){
						sql += ", " ;
					}
				}
			}
			
			sql += ") VALUES (" ;
			
			// Resetando o iterador
			i = this.table_fields.iterator() ;
			
			while ( i.hasNext() ){
				field = (FieldDb) i.next() ;
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
			PreparedStatement stmt = this.connection.prepareStatement(sql) ;
			i = this.table_fields.iterator() ;
			
			// Contador para substituicao dos '?' pelos valores
			int counter = 1 ;
			
			// Percorrendo os valores
			while (i.hasNext()) {
				field = (FieldDb) i.next() ;
				if ( ! field.isPrimaryKey() ) {
					stmt.setString( counter++ , field.getValue() ) ;
				}
			}
			
			// Preenchendo o valor da chave primaria caso o registro exista
			if ( this._exists && primaryKey != null ) {
				stmt.setString( counter , primaryKey.getValue() ) ;
			}

			//Executando a query
			boolean execute = stmt.execute() ;
			
			// Atualizando o valor do id caso o registro ainda nao exista
			if ( ! this._exists ) {
				ResultSet rs = stmt.getGeneratedKeys() ;
				i = this.table_fields.iterator() ;
				if ( rs != null && rs.next() ) {
					while ( i.hasNext() ) {
						field = (FieldDb) i.next() ;
						if ( field.isPrimaryKey() ) {
							field.setValue(rs.getString(field.getField())) ;
							break ;
						}
					}
				}
				
				this._exists = true ;
			}
			
			return execute ;
		} catch (SQLException e){
			return false ;
		}
		
	}
	
}
