package br.edu.mackenzie.controller.action.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.controller.action.Action;
import br.edu.mackenzie.dao.ReservaFactory;
import br.edu.mackenzie.model.*;

public class FazerReserva implements Action {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter() ;
		
		// Factory que faz a reserva
		Reserva r = ReservaFactory.criaReserva(request) ;
		
		if ( r != null ) {
			request.setAttribute( "success" , "yes" ) ;
			request.setAttribute( "reserva_id" , r.getPrimaryKey() ) ;
		}
		else {
			request.setAttribute( "success" , "no" ) ;
			request.setAttribute("messages" , ReservaFactory.messages ); // Setando Lista de nomes	
		}
		
		request.getRequestDispatcher("reserva_resultado.jsp").forward(request, response) ;
		
	}
	
} 
