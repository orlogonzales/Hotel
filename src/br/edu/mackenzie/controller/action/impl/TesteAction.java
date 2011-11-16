package br.edu.mackenzie.controller.action.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.controller.action.Action;
import br.edu.mackenzie.model.Hotel;

public class TesteAction implements Action {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Hotel> lista;
		List nomes = new ArrayList();
		try {
			lista = Hotel.getHoteis();
			for(Hotel hotel:lista){
				nomes.add(hotel.get("nome"));
			}
			request.setAttribute("nomes", nomes); // Setando Lista de nomes
		} catch (SQLException e) {
			//Tratar erro SQL
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/reservas.jsp");
		rd.forward(request, response);
	}
}
