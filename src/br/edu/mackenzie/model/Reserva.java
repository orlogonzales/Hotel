package br.edu.mackenzie.model;

import java.sql.SQLException;

public class Reserva extends Model {
	
	public Reserva() throws SQLException {
		super();
	}
	
	public Reserva(int id) throws SQLException {
		super(id);
	}
	
	@Override
	protected String getTableName() { return "reservas_tb" ; }
	
	public void ocuparReserva(){
		this.set("ocupado","yes");
		try {
			Quarto quarto = new Quarto(Integer.parseInt(this.get("quarto_id")));
			if(quarto.exists()){
				quarto.set("ocupado","yes");
				quarto.set("reservado", "no");
				quarto.save();
			}
			this.save();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
