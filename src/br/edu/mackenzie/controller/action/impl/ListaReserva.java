package br.edu.mackenzie.controller.action.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.controller.action.Action;
import br.edu.mackenzie.dao.ConnectionFactory;
import br.edu.mackenzie.model.Cliente;
import br.edu.mackenzie.model.Hotel;
import br.edu.mackenzie.model.Reserva;

public class ListaReserva implements Action {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idReserva");

		try {
			// Popula Reserva
			Reserva reserva = new Reserva(Integer.parseInt(id));
			System.out.println(reserva);
			if (!reserva.exists() || reserva.get("ocupado").equals("yes"))
				request.setAttribute("existe", false);
			else {
				request.setAttribute("existe", true);
				// Popula Hotel
				Hotel hotel = new Hotel(Integer.parseInt(reserva.get("hotel_id")));

				// Popula Cliente
				Cliente cliente = new Cliente(Integer.parseInt(reserva.get("cliente_id")));

				// Transforma pra Date de volta
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dataIn = df.parse((reserva.get("check_in")));
				Date dataOut = df.parse((reserva.get("check_out")));

				// Set o request
				request.setAttribute("id", reserva.get("reserva_id"));
				request.setAttribute("hotel", hotel.get("nome"));
				request.setAttribute("cliente", cliente.get("nome"));
				request.setAttribute("quarto", reserva.get("quarto_id"));
				request.setAttribute("check_in", dataIn);
				request.setAttribute("check_out", dataOut);
				request.setAttribute("cafe", reserva.get("cafe"));
			}

		} catch (SQLException e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		} catch (ParseException a) {
			a.printStackTrace();
			System.out.println("Erro na convers‹o de data");
		} catch (NullPointerException b) {
			System.out.println("NullPointerException!");
			b.printStackTrace();
		} catch (NumberFormatException c){
			System.out.println("Parse EXCEPTION!");
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("/listaReserva.jsp");
		rd.forward(request, response);

	}
}
