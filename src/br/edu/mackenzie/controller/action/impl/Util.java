package br.edu.mackenzie.controller.action.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	/**
	 * Converte uma data para o formato Mysql
	 * @param date
	 * @return
	 */
	public static String date_to_mysql(String date) {
		
		String value = null ;
		
		Pattern p = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})") ;
		Matcher m = p.matcher(date) ;
		
		if ( m.matches() ){
			value = m.group(3) + "-" + m.group(2) + "-" + m.group(1) ;
		}
		System.out.println(value);
		return value ;
	}
	
}
