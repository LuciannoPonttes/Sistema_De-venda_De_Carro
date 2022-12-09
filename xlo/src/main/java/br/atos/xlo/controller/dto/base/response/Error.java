package br.atos.xlo.controller.dto.base.response;

public class Error {
	private int code;
	private String descriptor;

	public Error() {

	}

	public Error(int code, String descriptor) {
		this.code = code;
		this.descriptor = descriptor;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public String toString() {
		return "Error{" + "code=" + code + ", descriptor='" + descriptor + '\'' + '}';
	}
}
