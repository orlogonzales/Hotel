package br.edu.mackenzie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

		return DriverManager.getConnection("jdbc:mysql://localhost/hotel_db", "root", "123");
	}
	
	/**
	 * Constroi um ResultSet para consulta e retorna o mesmo baseado na query passada
	 * @throws SQLException 
	 */
	public static ResultSet executeQuery(String sql) throws SQLException{
		ConnectionFactory factory = ConnectionFactory.getInstance() ;
		
		// Cria a conexão
		Connection connection = (Connection) factory.getConnection() ;
		
		// Cria o Statement
		Statement stmt = connection.createStatement() ;
		
		ResultSet rs = stmt.executeQuery(sql) ;
		
		return rs ;
	}

}
