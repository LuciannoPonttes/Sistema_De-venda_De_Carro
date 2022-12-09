package br.atos.xlo.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusUsuarioEnum {
	DESABILITADO(0), HABILITADO(1), PENDENTE(2);

	private final int value;

	StatusUsuarioEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static StatusUsuarioEnum fromValue(String text) {
		for (StatusUsuarioEnum b : StatusUsuarioEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

}
