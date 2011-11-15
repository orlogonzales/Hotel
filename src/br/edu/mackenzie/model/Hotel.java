package br.edu.mackenzie.model;

import java.sql.SQLException;
import java.util.ArrayList;

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
	 * @throws SQLException 
	 */
	public ArrayList<Hotel> getHoteis() throws SQLException {
		ConnectionFactory factory = ConnectionFactory.getInstance() ;
		Connection connection = (Connection) factory.getConnection() ;
		return null;
		
	}
}
