package br.edu.mackenzie.model;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.edu.mackenzie.dao.ConnectionFactory;

public class Hotel extends Model {
	
	public Hotel() throws SQLException {
		super();
	}
	
	public Hotel(int id) throws SQLException {
		super(id);
	}

	@Override
	protected String getTableName() { return "hoteis_tb" ; }

	/**
	 * Retorna a lista de hotéis
	 */
	public ArrayList<Hotel> getHoteis() {
		ConnectionFactory factory = ConnectionFactory.getInstance() ;
		Connection connection = (Connection) factory.getConnection() ;
		
	}
}
