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
	 * Coneçao com o banco
	 */
	private Connection connection ;
	
	/**
	 * Nome da tabela no banco
	 * Por convençao, a tabela deve ter o nome "nome_da_tabela" + "_tb"
	 */
	private String tableName = this.getClass().getName().toLowerCase() ;
	
	/**
	 * Lista de campos da tabela
	 */
	private ArrayList<FieldDb> table_fields = new ArrayList<FieldDb>() ;
	
	/**
	 * Determina se o registro existe.
	 */
	private boolean _exists = false ;

	/**
	 * Popula o atributo table_fields com os campos da tabela
	 * @throws SQLException 
	 */
	private void populateConfig() throws SQLException {
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
	public void getRegister(int id) throws SQLException{
		String sql = "select * from ? where ? = ?" ;
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, this.tableName + "_tb" ) ;
		stmt.setString(2, this.tableName + "_id" ) ;
		stmt.setInt(3, id) ;
		ResultSet rs = stmt.executeQuery() ;
		Iterator i = this.table_fields.listIterator();
		FieldDb field ;
		if ( rs.next() ){
			while ( i.hasNext() ){
				field = i.getClass() ;
				
			}
		}
	}
	
	/**
	 * Construtor que inicializa a conexao, popula a lista de campos da tabela e obtem o registro
	 * caso o id do campo seja passado
	 * @param id
	 * @throws SQLException
	 */
	public Model(int id) throws SQLException {
		ConnectionFactory factory = ConnectionFactory.getInstance() ;
		this.connection = factory.getConnection() ;
		this.populateConfig();
		
		if (id > 0){
			
		}
		
	}
	
}
