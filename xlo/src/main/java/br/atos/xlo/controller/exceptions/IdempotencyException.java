package br.atos.xlo.controller.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdempotencyException extends RuntimeException {

	private static final long serialVersionUID = -5666307449897249364L;

	private static final Logger logger = LogManager.getLogger(IdempotencyException.class.getName());

	private static final String MESSAGE = "Operation already performed: {0}";

	public IdempotencyException(String referenceId) {
		super(MESSAGE + referenceId);
		logger.error(MESSAGE, referenceId);
	}
}