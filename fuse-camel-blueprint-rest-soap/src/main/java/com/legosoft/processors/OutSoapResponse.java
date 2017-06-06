package com.legosoft.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.legosoft.model.response.pojo.PersonResponse;

public class OutSoapResponse implements Processor {

	private static final Logger LOGGER = Logger.getLogger(OutSoapResponse.class);

	@Override
	public void process(Exchange exchange) throws Exception {

		String respuesta = exchange.getIn().getBody(String.class);

		LOGGER.info("respuesta " + respuesta);

		PersonResponse res = new PersonResponse();
		res.setNombre(respuesta);
		res.setaMaterno("PRUEBA");
		res.setaPaterno("APELLIDO PATERNO");
		
		exchange.getOut().setBody(res);

		exchange.getOut().setHeader("Content-Type", "application/json");
		exchange.getOut().setHeader(Exchange.HTTP_METHOD, "POST");
	}
}
