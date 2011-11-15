package br.edu.mackenzie.model;

import java.sql.SQLException;

public class Usuario extends Model {
	
	/**
	 * Retorna o nome da tabela do model em uso
	 */
	@Override
	String getTableName() { return "usuarios" ;	}
	
	public Usuario() throws SQLException {
		super();
	}
	
	public Usuario(int id) throws SQLException{
		super(id) ;
	}

}
