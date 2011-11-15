package br.edu.mackenzie.model;

import java.sql.SQLException;

public class Quarto extends Model {

	public Quarto() throws SQLException {
		super();
	}
	
	public Quarto(int id) throws SQLException {
		super(id);
	}
	
	@Override
	protected String getTableName() { return "quartos_tb" ; }

}
