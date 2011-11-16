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
		
		Reserva r = ReservaFactory.criaReserva(request) ;
		
		out.println("Reserva feita, nro " + r.getPrimaryKey() ) ;
		
	}
	
} 
