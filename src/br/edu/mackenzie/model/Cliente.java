package br.edu.mackenzie.model;

import java.sql.SQLException;

public class Cliente extends Model {

	public Cliente() throws SQLException {
		super();
	}
	
	public Cliente(int id) throws SQLException {
		super(id);
	}
	
	@Override
	protected String getTableName() {
		return "clientes_tb" ;
	}

}
