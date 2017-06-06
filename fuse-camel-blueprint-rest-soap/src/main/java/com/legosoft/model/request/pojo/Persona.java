package com.legosoft.model.request.pojo;

public class Persona {
	
	private String nombre;
	private String apellidop;
	private String apellidom;
	
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellidop, String apellidom) {
		super();
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidop=" + apellidop + ", apellidom=" + apellidom + "]";
	}

	public String getApellidop() {
		return apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getApellidom() {
		return apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
