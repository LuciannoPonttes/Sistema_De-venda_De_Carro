package br.atos.xlo.controller.exceptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

	private static final String TIMESTAMP = "timestamp";
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		Object timestamp = errorAttributes.get(TIMESTAMP);
		if (timestamp == null) {
			errorAttributes.put(TIMESTAMP, dateFormat.format(new Date()));
		} else {
			errorAttributes.put(TIMESTAMP, dateFormat.format((Date) timestamp));
		}
		return errorAttributes;
	}
}
