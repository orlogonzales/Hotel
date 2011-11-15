package br.edu.mackenzie.controller.action.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.controller.action.Action;
import br.edu.mackenzie.model.Usuario;

public class FazerReserva implements Action {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter() ;
		out.println("OK---2") ;
		// Testes do model
		Usuario u;
		try {
			u = new Usuario(87) ;
			u.set("endereco", "Estr. Tenente marques") ;
			//u.set( "nome" , "Bianca Rodrigues da Silva" ) ;
			//u.set( "telefone" , "75054139" ) ;
			u.save() ;
			
			if ( u.exists() ){
				out.println(u.get("nome") + " - " + u.get("telefone")) ;
				out.println(u.get("usuarios_id")) ;
				//u.remove() ;
			}
			else {
				out.println("Não existe!") ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
