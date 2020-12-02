package com.banco.entidades;

import java.util.HashMap;

public class Datos {

	// HashMap de gestores
	private HashMap<String, Gestor> gestores;
	
	// HashMap de mensajes
	// private HashMap<Integer, Mensaje> mensajes;
	
	// HashMap de clientes
	
	// HashMap de transferencias
	
	// HashMap de préstamos
	
	// constructor por defecto
	public Datos() {
		this.gestores = new HashMap<String, Gestor>();
		//this.mensajes = new HashMap<Integer,Mensaje>();
	}

	// método get para obtener los gestores
	public HashMap<String, Gestor> getGestores() {
		return gestores;
	}	
}
