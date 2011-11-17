package br.edu.mackenzie.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import br.edu.mackenzie.controller.action.impl.Util;
import br.edu.mackenzie.model.Cliente;
import br.edu.mackenzie.model.Hotel;
import br.edu.mackenzie.model.Quarto;
import br.edu.mackenzie.model.Reserva;

public class ReservaFactory {
	
	/**
	 * Mensagens de erro
	 */
	public static ArrayList<String> messages = new ArrayList<String>() ;
	
	/**
	 * Método que faz a reserva e retorna uma referencia para a mesma
	 * @param	HttpServletRequest	Dados vindos do formulário
	 * @author	alissonperez
	 */
	public static Reserva criaReserva(HttpServletRequest request) {
		
		Cliente cliente = null ;
		Reserva reserva = null ;
		
		// Controle os erros no formulário
		boolean error = false ;
		
		// Resetando mensagens para o usuário
		ReservaFactory.messages.clear() ;
		
		try {
			cliente = new Cliente() ;
			cliente.populate(request) ;
			
			if ( cliente.is_valid() ) {
				reserva = new Reserva() ;
				reserva.populate(request) ;

				// Setando a data de entrada
				String check_in = Util.date_to_mysql(request.getParameter("check_in")) ;
				if ( check_in != null ) {
					reserva.set("check_in", check_in) ;
				} else {
					error = true ;
					ReservaFactory.messages.add("Dada de entrada incorreta!") ;
				}

				// Setando a data de saida
				String check_out = Util.date_to_mysql(request.getParameter("check_out")) ;
				if ( check_out != null ) {
					reserva.set("check_out", check_out) ;
				} else {
					error = true ;
					ReservaFactory.messages.add("Dada de saida incorreta!") ;
				}
				
				// Obtendo o Hotel
				Hotel hotel = null ;
				if ( request.getParameter("hotel") != null && request.getParameter("hotel") != "" ) {
					hotel = new Hotel(Integer.parseInt(request.getParameter("hotel"))) ;
					if ( hotel.exists() ) {
						reserva.set("hotel_id", hotel.getPrimaryKey()) ;
					}
					else error = true ;
				}
				else error = true ;
				
				// Obtendo o Quarto
				Quarto quarto = null ;
				if ( ! error && request.getParameter("tipo_quarto") != null && request.getParameter("tipo_quarto") != "" ) {
					quarto = Quarto.getQuartoLivre(Integer.parseInt(reserva.get("hotel_id")), request.getParameter("tipo_quarto")) ;
					if ( quarto != null ) {
						reserva.set("quarto_id", quarto.getPrimaryKey()) ;
					}
					else {
						error = true ;
						ReservaFactory.messages.add("Quarto não disponível para o Hotel selecionado, tente outro") ;
					}
				}
				else {
					error = true ;
					messages.add("Selecione um quarto");
				}
				
				if ( ! error ){
					cliente.save() ;
					reserva.set("cliente_id", cliente.getPrimaryKey()) ;
				//	System.out.println(reserva);
					reserva.set("ocupado", "no");
					if ( reserva.save() ) {
						quarto.set("reservado", "yes") ;
						quarto.save() ;
					}
					else {
						error = true ;
						ReservaFactory.messages.add("Ouve um erro ao gravar a reserva") ;
					}
				}
			}
			
			//r = new Reserva() ;
			//reserva.populate(request) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ! error ? reserva : null ;
		
	}
	
}
