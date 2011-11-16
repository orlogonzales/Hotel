package br.edu.mackenzie.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.mackenzie.dao.ConnectionFactory;

public class Quarto extends Model {

	public Quarto() throws SQLException {
		super();
	}
	
	public Quarto(int id) throws SQLException {
		super(id);
	}
	
	/**
	 * Retorna o primeiro quarto livre de um determinado tipo e hotel
	 * @author	alissonperez
	 */
	public static Quarto getQuartoLivre(int hotel_id, String tipo){
		Quarto q = null ;
		try {
			ResultSet rs = ConnectionFactory.executeQuery("SELECT * FROM quartos_tb WHERE hotel_id = " + hotel_id + " and tipo = '" + tipo + "' and ocupado = 'no' and reservado = 'no'") ;
			//System.out.println("SELECT * FROM quartos_tb WHERE hotel_id = " + hotel_id + " and tipo = '" + tipo + "' and ocupado = 'no'") ;
			if ( rs.next() ) {
				q = new Quarto() ;
				q.populate(rs) ;
			}
			rs.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q ;
	}
	
	@Override
	protected String getTableName() { return "quartos_tb" ; }

}
