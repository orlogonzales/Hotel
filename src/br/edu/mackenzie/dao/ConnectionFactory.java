package br.edu.mackenzie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//Singleton e Factory!
	
	private static boolean instanciado;
	private static ConnectionFactory instance;

	private ConnectionFactory() {

	}

	public static ConnectionFactory getInstance() {
		if (!instanciado) {
			instance = new ConnectionFactory();
			instanciado = true;
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		return DriverManager.getConnection("jdbc:mysql://localhost/hotel_db",
				"root", "");
	}

}
