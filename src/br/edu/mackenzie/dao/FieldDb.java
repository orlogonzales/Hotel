package br.edu.mackenzie.dao;

/**
 * Gerencia o campo no banco de dados
 * @autho	administrador
 * @since	07/11/2011 09:14:00
 */
public class FieldDb {
	
	String field ;
	String value = null ;
	String type ;
	boolean isNull ;
	boolean isPrimaryKey ;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isNull() {
		return isNull;
	}
	public void setNull(String value) {
		this.isNull = value.equals("YES") ;
	}
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}
	public void setPrimaryKey(String value) {
		this.isPrimaryKey = value.equals("PRI") ;
	}

}
