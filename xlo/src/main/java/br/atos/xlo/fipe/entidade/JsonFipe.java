package br.atos.xlo.fipe.entidade;

public class JsonFipe {

	private String label;
	private String value;

	public JsonFipe(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	public JsonFipe() {
		super();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
