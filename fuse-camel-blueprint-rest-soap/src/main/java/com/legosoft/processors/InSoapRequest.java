package com.legosoft.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.legosoft.model.request.pojo.Persona;
import com.mkyong.ws.GetHelloWorldAsString;

public class InSoapRequest implements Processor{

	private static final Logger LOGGER = Logger.getLogger(InSoapRequest.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
	Persona rpcRequest = (Persona) exchange.getIn().getBody();
		
		GetHelloWorldAsString consulta = new GetHelloWorldAsString();
		
		consulta.setArg0(rpcRequest.getNombre());
				
		LOGGER.info("InSoapRequest");

		exchange.getOut().setBody(new Object[] {consulta.getArg0()});
	}
	

}
