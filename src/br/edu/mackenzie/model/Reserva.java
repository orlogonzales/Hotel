package br.edu.mackenzie.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.mackenzie.dao.ConnectionFactory;

public class Reserva extends Model {
	
	public Reserva() throws SQLException {
		super();
	}
	
	public Reserva(int id) throws SQLException {
		super(id);
	}

	@Override
	protected String getTableName() { return "reservas_tb" ; }
	
	/**
	 * Retorna a lista de hotéis
	 * @throws SQLException 
	 */
	public static ArrayList<Reserva> getReservas() throws SQLException {
		ResultSet rs = ConnectionFactory.executeQuery("SELECT * FROM reservas_tb") ;
		
		// Armazena a lista de reservas
		ArrayList<Reserva> list_reservas = new ArrayList<Reserva>() ;
		
		Reserva field ;
		
		while ( rs.next() ) {
			field = new Reserva() ;
			field.populate(rs) ;
			list_reservas.add(field) ;
		}
		
		rs.close() ;
		
		return list_reservas ;
	}
}
