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
			u = new Usuario(30) ;
			u.set( "nome" , "Alisson dos reis Perez222" ) ;
			u.set( "telefone" , "12390381092" ) ;
			u.save() ;
			
			if ( u.exists() ){
				out.println(u.get("nome")) ;
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
