package com.legosoft.model.response.pojo;

public class PersonResponse {

	private String nombre;
	private String aPaterno;
	private String aMaterno;

	public PersonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonResponse(String nombre, String aPaterno, String aMaterno) {
		super();
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
	}

	@Override
	public String toString() {
		return "PersonResponse [nombre=" + nombre + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

}
