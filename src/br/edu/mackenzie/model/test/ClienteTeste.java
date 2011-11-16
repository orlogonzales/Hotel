package br.edu.mackenzie.model.test;

import java.sql.SQLException;

import br.edu.mackenzie.model.Cliente;

public class ClienteTeste {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.set("nome","Cesar");
		cliente.set("email","cesarvargas00@gmail.com");
		cliente.set("estado","SP");
		cliente.set("pais","Brasil");
		cliente.set("endereco","Al. Sidney n362 Tambore 2");
		cliente.set("id","1");
		cliente.save();
	}

}
