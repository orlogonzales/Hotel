package br.edu.mackenzie.controller.action.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.controller.action.Action;
import br.edu.mackenzie.dao.ConnectionFactory;
import br.edu.mackenzie.model.Reserva;

public class ListaReserva implements Action {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idReserva");

		try {
			Reserva reserva = new Reserva();
			ResultSet values = ConnectionFactory
					.executeQuery("select * from reservas_tb where reserva_id ="
							+ id + ";");
			while (values.next()) {
				reserva.populate(values);
			}
			request.setAttribute("id", reserva.get("reserva_id"));
			request.setAttribute("hotel", reserva.get("hotel_id"));
			request.setAttribute("cliente", reserva.get("cliente_id"));
			request.setAttribute("quarto", reserva.get("quarto_id"));
			request.setAttribute("check_in", reserva.get("check_in"));
			request.setAttribute("check_out", reserva.get("check_out"));

		} catch (SQLException e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("/listaReserva.jsp");
		rd.forward(request, response);

	}
}
