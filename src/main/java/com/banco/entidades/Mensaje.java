package com.banco.entidades;

import java.time.LocalDateTime;

public class Mensaje {

	// atributos
	private int id;
	private int idOrigen;
	private int idDestino;
	private String texto;
	private LocalDateTime fecha;

	// constructor parametrizado
	public Mensaje(int id, int idOrigen, int idDestino, String texto, LocalDateTime fecha) {
		this.id = id;
		this.idOrigen = idOrigen;
		this.idDestino = idDestino;
		this.texto = texto;
		this.fecha = fecha;		
	}

	// métodos getters y setters

	public int getId() {
		return id;
	}

	public int getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
