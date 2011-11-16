package br.edu.mackenzie.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public static ArrayList<Hotel> getHoteis() throws SQLException {
		ResultSet rs = ConnectionFactory.executeQuery("SELECT * FROM hoteis_tb") ;
		
		// Armazena a lista de hoteis
		ArrayList<Hotel> list_hotels = new ArrayList<Hotel>() ;
		
		Hotel field ;
		
		while ( rs.next() ) {
			field = new Hotel() ;
			field.populate(rs) ;
			list_hotels.add(field) ;
		}
		
		rs.close() ;
		
		return list_hotels ;
	}
}