package br.atos.xlo.controller.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.JsonMappingException;

import br.atos.xlo.controller.dto.base.response.Error;
import br.atos.xlo.controller.dto.base.response.ResponseNodeError;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {

	private static final Logger logger = LogManager.getLogger(CustomGlobalExceptionHandler.class.getName());

	private static final String HTTPSTATUS = "HttpStatus: {}";
	private static final String ERRORS = "Error: {}";
	private static final String MESSAGE = "Message: {}";

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	public ResponseNodeError customHandleInternalServerError(Exception ex, WebRequest request) {
		return getResponseBodyError(HttpStatus.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseNodeError customHandleNotFound(Exception ex, WebRequest request) {
		return getResponseBodyError(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase(), ex);
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ResponseNodeError customUnSupportedFieldPatch(Exception ex, WebRequest request) {
		return getResponseBodyError(HttpStatus.METHOD_NOT_ALLOWED, HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), ex);
	}

	@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
	@ExceptionHandler(IdempotencyException.class)
	public ResponseNodeError idempotencyException(Exception ex, WebRequest request) {
		return getResponseBodyError(HttpStatus.TOO_MANY_REQUESTS, ex.getMessage(), ex);
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ResourceAlreadyExists.class)
	public ResponseNodeError resourceAlreadyExists(Exception ex, WebRequest request) {
		return getResponseBodyError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.getReasonPhrase(), ex);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseNodeError constraintViolationException(Exception ex, WebRequest request) {
		return getResponseBodyError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	public ResponseNodeError httpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {

		if (ex.getCause() instanceof JsonMappingException) {
			StringBuilder message = new StringBuilder();
			StringTokenizer str = new StringTokenizer(ex.getLocalizedMessage());
			message.append(str.nextToken(":"));
			message.append(str.nextToken(":"));
			message.append(str.nextToken(";"));
			return getResponseBodyError(HttpStatus.BAD_REQUEST, message.toString(), ex);
		}
		return getResponseBodyError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MissingServletRequestParameterException.class })
	public ResponseNodeError missingServletRequestParameterException(MissingServletRequestParameterException ex,
			WebRequest request) {
		StringBuilder message = new StringBuilder();
		StringTokenizer str = new StringTokenizer(ex.getLocalizedMessage());
		message.append(str.nextToken("]"));
		return getResponseBodyError(HttpStatus.BAD_REQUEST, message.toString(), ex);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseNodeError handleMethodNotValid(MethodArgumentNotValidException ex) {

		List<Error> errors = new ArrayList<>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

		fieldErrors.forEach(fieldError -> {
			String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			Error error = new Error(HttpStatus.BAD_REQUEST.value(), fieldError.getField() + " - " + message);
			errors.add(error);
		});

		return getResponseBodyError(HttpStatus.BAD_REQUEST, errors, ex);
	}

	private static ResponseNodeError getResponseBodyError(HttpStatus httpStatus, List<Error> errors, Exception ex) {
		ResponseNodeError responseBodyError = new ResponseNodeError(httpStatus.value(), errors);

		printLoggerError(httpStatus, errors, ex);

		return responseBodyError;
	}

	private static ResponseNodeError getResponseBodyError(HttpStatus httpStatus, String description, Exception ex) {

		Error error = new Error(httpStatus.value(), description);

		List<Error> errors = new ArrayList<>();
		errors.add(error);

		ResponseNodeError responseBodyError = new ResponseNodeError(httpStatus.value(), errors);

		printLoggerError(httpStatus, errors, ex);

		return responseBodyError;
	}

	private static void printLoggerError(HttpStatus httpStatus, List<Error> errors, Exception ex) {
		final String httpStatusValue = String.valueOf(httpStatus.value());
		final String errorsList = String.valueOf(errors.toString());
		final String message = String.valueOf(ex.getMessage());

		logger.error(HTTPSTATUS, httpStatusValue);
		logger.error(ERRORS, errorsList);
		logger.error(MESSAGE, message);
	}
}