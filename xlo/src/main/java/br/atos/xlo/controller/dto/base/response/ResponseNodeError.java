package br.atos.xlo.controller.dto.base.response;

import java.util.List;

public class ResponseNodeError {
	private int status;
	private List<Error> errors;

	public ResponseNodeError() {

	}

	public ResponseNodeError(int status, List<Error> errors) {
		this.status = status;
		this.errors = errors;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ResponseNodeError{" + "status=" + status + ", errors=" + errors + '}';
	}
}
