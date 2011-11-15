package br.edu.mackenzie.model;

import java.sql.SQLException;

public class Reserva extends Model {
	
	public Reserva() throws SQLException {
		super();
	}
	
	public Reserva(int id) throws SQLException {
		super(id);
	}

	@Override
	protected String getTableName() { return "reservas_tb" ; }
}
