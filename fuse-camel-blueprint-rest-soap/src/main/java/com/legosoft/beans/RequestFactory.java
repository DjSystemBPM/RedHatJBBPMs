package com.legosoft.beans;

import org.apache.camel.Exchange;

import com.legosoft.model.request.pojo.Persona;


/**
 * 
 * @author Alfredo Cuevas
 * @version 1.0.0
 * @category Request Factory Red Hat JBoss Fuse
 * @since 2017/03/14
 * 
 */
public class RequestFactory {


	public Persona saveBodyOnProps(Exchange message) {

		// Se obtiene mensaje de entrada
		Persona persona = (Persona) message.getIn().getBody();

		message.setProperty("persona", persona);

		return persona;
	}

	public Persona restoreRequest(Exchange message) {

		// Se obtiene mensaje de entrada
		Persona persona = (Persona) message
				.getProperty("persona");

		return persona;
	}

}

