package br.atos.xlo.controller.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResourceAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = -4540665939284579589L;

	private static final Logger logger = LogManager.getLogger(ResourceAlreadyExists.class.getName());

	public ResourceAlreadyExists(String id) {
		super("Resource " + id + " already exists.");
		logger.error("Resource already exists %s", id);
	}
}