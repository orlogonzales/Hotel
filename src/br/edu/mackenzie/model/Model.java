package br.edu.mackenzie.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import br.edu.mackenzie.dao.ConnectionFactory;
import br.edu.mackenzie.dao.FieldDb;

import com.mysql.jdbc.Statement;

//TODO Fazer método Populate para popular os valores do objeto com um recordset
public abstract class Model {

	/**
	 * Conexao com o banco
	 */
	private Connection connection;

	/**
	 * Nome da tabela no banco Por conven�ao, a tabela deve ter o nome
	 * "nome_da_tabela" + "_tb"
	 */
	private String tableName = null;

	/**
	 * Nome da chave primária da tabela
	 */
	private String primaryKeyName = null;

	/**
	 * Lista de campos da tabela usando HashMap
	 */
	public HashMap<String, FieldDb> tableFields = new HashMap<String, FieldDb>();

	/**
	 * Determina se o registro existe.
	 */
	private boolean _exists = false;

	/**
	 * Retorna o nome da tabela
	 */
	protected abstract String getTableName();

	/**
	 * Popula o atributo tableFields com os campos da tabela
	 * 
	 * @throws SQLException
	 */
	private void _populateConfig() throws SQLException {
		Statement stmt = (Statement) this.connection.createStatement();
		ResultSet rs = stmt.executeQuery("desc " + this.tableName);
		FieldDb field;

		// Percorrendo os registros encontrados
		while (rs.next()) {
			field = new FieldDb();
			field.setValue(null);
			field.setField(rs.getString("field"));
			field.setType(rs.getString("type"));
			field.setNull(rs.getString("null"));
			field.setPrimaryKey(rs.getString("KEY"));
			if (field.isPrimaryKey()) {
				// System.out.println("PK: " + field.getField())
				this.primaryKeyName = rs.getString("field");
			}
			// System.out.println(rs.getString("field") + "-" +
			// rs.getString("type") + "-" + rs.getString("null") );
			this.tableFields.put(rs.getString("field"), field);
		}

		rs.close();
		stmt.close();
	}

	/**
	 * Obtem um registro passando-se a chave primaria TODO Tratar SQLException
	 * 
	 * @param id
	 * @throws SQLException
	 */
	private void _getRegister(int id) throws SQLException {
		String sql = "select * from " + this.tableName + " where "
				+ this.primaryKeyName + " = ?";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);
		System.out.println(stmt.toString());
		ResultSet rs = stmt.executeQuery();
		Set<String> key_fields = this.tableFields.keySet();
		Iterator<String> i = key_fields.iterator();
		FieldDb field;
		if (rs.next()) {
			this._exists = true;
			while (i.hasNext()) {
				field = (FieldDb) this.tableFields.get(i.next());
				field.setValue(rs.getString(field.getField()));
				System.out.println(field.getField() + ": "
						+ rs.getString(field.getField()));
			}
		} else {
			this._exists = false;
		}
		rs.close();
	}

	/**
	 * Inicia uma conexao
	 * 
	 * @author alissonperez
	 * @throws SQLException
	 */
	private void _startConnection() throws SQLException {
		ConnectionFactory factory = ConnectionFactory.getInstance();
		this.connection = factory.getConnection();
	}

	/**
	 * Construtor que inicializa a conexao, popula a lista de campos da tabela e
	 * obtem o registro caso o id do campo seja passado
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public Model(int id) throws SQLException {
		this.tableName = this.getTableName();
		this._startConnection();
		this._populateConfig();

		if (id > 0) {
			this._getRegister(id);
		}
	}

	/**
	 * Sobrecarga do construtor quando nao se tem id (um novo objeto)
	 * 
	 * @author alissonperez
	 */
	public Model() {

		this.tableName = this.getTableName();
		try {
			this._startConnection();
			this._populateConfig();
			// TODO: handle exception
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro na criação do model");
		}
	}

	/**
	 * Seta o valor no campo especificado no parametro
	 * 
	 * @author alissonperez
	 * @param name
	 *            Nome do campo
	 * @param value
	 *            Valor do campo
	 */
	public boolean set(String name, String value) {
		FieldDb field = this.tableFields.get(name);
		if (field != null && !field.isPrimaryKey()) {
			field.setValue(value);
			return true;
		}
		return false;
	}

	/**
	 * Retorna o valor de um campo
	 * 
	 * @author alissonperez
	 * @param name
	 *            Nome do campo
	 */
	public String get(String name) {
		FieldDb field = this.tableFields.get(name);
		if (field != null) {
			return field.getValue();
		}
		return null;
	}

	/**
	 * Retorna o valor da chave primária
	 * 
	 * @author AlissonPerez
	 * @return int
	 */
	public String getPrimaryKey() {
		if (this._exists) {
			FieldDb field = this.tableFields.get(this.primaryKeyName);
			return field.getValue();
		}
		return "";
	}

	/**
	 * Verifica se o registro existe
	 */
	public boolean exists() {
		// System.out.println("False: " + this._exists );
		return this._exists;
	}

	/**
	 * Validação simples do registro
	 * 
	 * @author alissonperez
	 * @return boolean Se o registro é valido para gravação ou não
	 */
	// TODO Incluir mensagens de erro em uma variável
	public boolean is_valid() {
		Set<String> key_fields = this.tableFields.keySet();
		Iterator<String> i = key_fields.iterator();
		FieldDb field;
		while (i.hasNext()) {
			field = this.tableFields.get(i.next());
			if (!field.isPrimaryKey()) {
				// System.out.println("NULL: " + field.isNull() + "-" +
				// field.getValue() + " - " + field.getField() );
				if (!field.isNull() && field.getValue() == null) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Remove o registro do banco
	 * 
	 * @throws SQLException
	 */
	public boolean remove() throws SQLException {
		if (this._exists) {
			FieldDb primary_key = this.tableFields.get(this.primaryKeyName);
			String sql = "delete from " + this.tableName + " where "
					+ primary_key.getField() + "=" + primary_key.getValue();
			Statement stmt = (Statement) this.connection.createStatement();
			// System.out.println(stmt.toString());
			return stmt.execute(sql);
		}
		return false;
	}

	/**
	 * Popula o Objeto atravez de um ResultSet
	 * 
	 * @author alissonperez
	 * @param ResultSet
	 * @throws SQLException
	 */
	public void populate(ResultSet values) throws SQLException {
		if (values != null) {
			// Obtendo as chaves
			Set<String> key_fields = this.tableFields.keySet();

			// Iterador
			Iterator<String> i = key_fields.iterator();

			// Objeto field para setar os valores
			FieldDb field;
			while (i.hasNext()) {
				field = this.tableFields.get(i.next());
				// System.out.println("Populando campo: " + field.getField());
				field.setValue(values.getString(field.getField()));
			}
			this._exists = true;
		}
		else System.out.println("Valores Nulos!");
	}

	/**
	 * Popula o Objeto atravez de um Request
	 * 
	 * @author alissonperez
	 * @param ResultSet
	 * @throws SQLException
	 */
	// TODO Verificar questão a chave primária quando for setada por um request
	public void populate(HttpServletRequest values) throws SQLException {
		// Obtendo as chaves
		Set<String> key_fields = this.tableFields.keySet();

		// Iterador
		Iterator<String> i = key_fields.iterator();

		// Objeto field para setar os valores
		FieldDb field;
		while (i.hasNext()) {
			field = this.tableFields.get(i.next());
			if (values.getParameter(field.getField()) != null) {
				field.setValue(values.getParameter(field.getField()));
				// System.out.println( "Populando campo #" + field.getField() +
				// "# com #" + field.getValue() + "#" ) ;
			}
		}
	}

	/**
	 * Salva os dados no banco
	 * 
	 * @author alissonperez
	 */
	public boolean save() {
		String sql = "";
		FieldDb field, primaryKey = null;

		// Obtendo as chaves
		Set<String> key_fields = this.tableFields.keySet();
		Iterator<String> i = key_fields.iterator();

		// Caso o registro exista devemos fazer um Update
		if (this._exists) {
			sql += "UPDATE " + this.tableName + " SET ";

			while (i.hasNext()) {
				field = (FieldDb) this.tableFields.get(i.next());
				if (field.isPrimaryKey()) {
					primaryKey = field;
				} else {
					sql += field.getField() + " = ?";
					if (i.hasNext()) {
						sql += ", ";
					}
				}
			}

			sql += " WHERE " + this.primaryKeyName + " = ?";
		}
		// Caso não devemos fazer um Insert
		else {
			sql += "INSERT INTO " + this.tableName + " (";
			while (i.hasNext()) {
				field = (FieldDb) this.tableFields.get(i.next());
				if (!field.isPrimaryKey()) {
					sql += field.getField();
					if (i.hasNext()) {
						sql += ", ";
					}
				}
			}

			sql += ") VALUES (";

			// Resetando o iterador
			i = key_fields.iterator();

			while (i.hasNext()) {
				field = (FieldDb) this.tableFields.get(i.next());
				if (!field.isPrimaryKey()) {
					sql += "?";
					if (i.hasNext()) {
						sql += ",";
					}
				}
			}

			sql += ")";
		}

		// Preparando o statement
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			i = key_fields.iterator();

			// Contador para substituicao dos '?' pelos valores
			int counter = 1;

			// Percorrendo os valores
			while (i.hasNext()) {
				field = (FieldDb) this.tableFields.get(i.next());
				if (!field.isPrimaryKey()) {
					stmt.setString(counter++, field.getValue());
				}
			}

			// Preenchendo o valor da chave primaria caso o registro exista
			if (this._exists && primaryKey != null) {
				stmt.setString(counter, primaryKey.getValue());
			}

			// if ( this.tableName == "quartos_tb" ) System.out.println(stmt) ;

			// Executando a query
			// System.out.println(stmt.toString());
			int execute = stmt.executeUpdate();

			// Atualizando o valor do id caso o registro ainda nao exista
			if (!this._exists && execute > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				i = key_fields.iterator();
				if (rs != null && rs.next()) {
					while (i.hasNext()) {
						field = (FieldDb) this.tableFields.get(i.next());
						if (field.isPrimaryKey()) {
							field.setValue(rs.getString(1));
							break;
						}
					}
				}

				this._exists = true;
			}

			return execute > 0;
		} catch (SQLException e) {
			return false;
		}

	}

	/**
	 * Implementação do método toString
	 * 
	 * @author alissonperez
	 * @return String
	 */
	public String toString() {
		// Obtendo as chaves
		Set<String> key_fields = this.tableFields.keySet();

		// Iterador
		Iterator<String> i = key_fields.iterator();

		String value = "";

		// Objeto field para setar os valores
		FieldDb field;
		while (i.hasNext()) {
			field = this.tableFields.get(i.next());
			value += field.getField() + ": " + field.getValue() + "\n";
		}

		value += "'exists': " + this._exists + "\n";

		return value;
	}

}
