package br.atos.xlo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusVeiculoEnum {
	INATIVO(0), ATIVO(1);

	private final int value;

	StatusVeiculoEnum(int value) {
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
	public static StatusVeiculoEnum fromValue(String text) {
		for (StatusVeiculoEnum b : StatusVeiculoEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
