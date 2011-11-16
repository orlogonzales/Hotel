package br.edu.mackenzie.controller.action.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.controller.action.Action;
import br.edu.mackenzie.model.*;

public class FazerReserva implements Action {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter() ;
		
		try {
			ArrayList<Hotel> list = Hotel.getHoteis() ;

			Iterator i = list.iterator() ;
			Hotel h ;
			while( i.hasNext() ){
				h = (Hotel) i.next() ;
				out.println(h.get("hotel_id") + " - " + h.get("nome")) ;
			}
			System.out.println("Tamanho: " + list.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
