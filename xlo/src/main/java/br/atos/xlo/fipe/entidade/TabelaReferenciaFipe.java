package br.atos.xlo.fipe.entidade;

public class TabelaReferenciaFipe {

	private Integer codigo;
	private String mes;

	public TabelaReferenciaFipe() {
		super();
	}

	public TabelaReferenciaFipe(Integer codigo, String mes) {
		super();
		this.codigo = codigo;
		this.mes = mes;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

}
