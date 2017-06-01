package io.fabric8.quickstarts.errors;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.language.NamespacePrefix;
import org.apache.camel.language.XPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class OrderService {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	private static final Random RANDOM = new Random();

	public void validateOrderDate(
			@XPath(value = "/order:order/order:date", namespaces = @NamespacePrefix(prefix = "order", uri = "http://fabric8.com/examples/order/v7")) String date)
			throws OrderValidationException {
		final Calendar calendar = new GregorianCalendar();
		try {
			calendar.setTime(DATE_FORMAT.parse(date));
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				LOGGER.warn("LA VALIDACION DE LA ORDEN FALLO: order date " + date + " NO PUEDE SER EN DOMINGO.");
				throw new OrderValidationException("LA FECHA DE ORDEN NO PUEDE CAER EN DOMINGO: " + date);
			}
		} catch (ParseException e) {
			throw new OrderValidationException("FECHA DE ORDEN INVALIDO: " + date);
		}
	}

	public void randomlyThrowRuntimeException(@Header(Exchange.FILE_NAME) String name) {
		if (RANDOM.nextInt(3) > 0) {
			LOGGER.warn("UNA INESPERADA EXCEPCION EN TIEMPO DE EJECUCION A OCURRIDO MIENTRAS SE PROCESABA EL ARCHIVO: "
					+ name);
			throw new RuntimeException("ALGO MAS SALIO MAL AL MANEJAR ESTE MENSAJE.");
		}
	}

	public static void main(String[] args) {
		if (RANDOM.nextInt(3) > 0) {
			System.out.println(RANDOM);
		}
	}
}
