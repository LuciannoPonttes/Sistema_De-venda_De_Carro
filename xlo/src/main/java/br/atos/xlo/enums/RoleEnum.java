package br.atos.xlo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleEnum {
	ADMINISTRADOR(1), USUARIO(2);

	private final int value;

	RoleEnum(int value) {
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
	public static RoleEnum fromValue(String text) {
		for (RoleEnum b : RoleEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
