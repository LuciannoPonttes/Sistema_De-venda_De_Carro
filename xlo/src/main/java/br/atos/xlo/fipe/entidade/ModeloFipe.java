package br.atos.xlo.fipe.entidade;

import java.util.List;

public class ModeloFipe {

	private List<JsonFipe> modelos;
	private List<JsonFipe> anos;

	public ModeloFipe() {
		super();
	}

	public ModeloFipe(List<JsonFipe> modelos, List<JsonFipe> anos) {
		super();
		this.modelos = modelos;
		this.anos = anos;
	}

	public List<JsonFipe> getModelos() {
		return modelos;
	}

	public void setModelos(List<JsonFipe> modelos) {
		this.modelos = modelos;
	}

	public List<JsonFipe> getAnos() {
		return anos;
	}

	public void setAnos(List<JsonFipe> anos) {
		this.anos = anos;
	}

}
