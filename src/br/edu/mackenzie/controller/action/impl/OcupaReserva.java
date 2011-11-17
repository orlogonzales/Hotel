package br.edu.mackenzie.controller.action.impl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.controller.action.Action;
import br.edu.mackenzie.model.Reserva;

public class OcupaReserva implements Action{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			try {
				Reserva reserva = new Reserva(Integer.parseInt(request.getParameter("idReserva")));
				reserva.ocuparReserva();
				System.out.println("foi!");
				boolean sucesso = true;
				request.setAttribute("sucesso",sucesso );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("listaReserva.jsp");
			rd.forward(request, response);
	}

}
