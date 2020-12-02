package com.banco.entidades;

import org.json.JSONObject;

public class Gestor {

	// atributos
	private int id;
	private String usuario;
	private String password;
	private String correo;
	
	// constructor parametrizado
	public Gestor(int id, String usuario, String password, String correo) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
	}
	
	public Gestor(String usuario, String password, String correo) {
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
	}

	public void mostrarDatos() {
		System.out.printf("Id: %d", this.id).println();
		System.out.printf("Usuario: %s", this.usuario).println();
		System.out.printf("Password: %s", this.password).println();
		System.out.printf("Correo: %s", this.correo).println();
	}


	// métodos getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public JSONObject convertirAJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", this.id);
		jsonObject.put("usuario", this.usuario);
		jsonObject.put("password", this.password);
		jsonObject.put("correo", this.correo);
		return jsonObject;
	}
	
}
