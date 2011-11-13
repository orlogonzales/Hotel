package br.edu.mackenzie.model.test;

import br.edu.mackenzie.model.Cliente;

public class ClienteTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
