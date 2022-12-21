package br.atos.xlo.dto;

public class ReferenciaFipeDTO {

	private int codigoTabelaReferencia;

	private String mesTabelaReferencia;

	public ReferenciaFipeDTO(int codigoTabelaReferencia, String mesTabelaReferencia) {
		super();
		this.codigoTabelaReferencia = codigoTabelaReferencia;
		this.mesTabelaReferencia = mesTabelaReferencia;
	}

	public ReferenciaFipeDTO() {
		super();
	}

	public int getCodigoTabelaReferencia() {
		return codigoTabelaReferencia;
	}

	public void setCodigoTabelaReferencia(int codigoTabelaReferencia) {
		this.codigoTabelaReferencia = codigoTabelaReferencia;
	}

	public String getMesTabelaReferencia() {
		return mesTabelaReferencia;
	}

	public void setMesTabelaReferencia(String mesTabelaReferencia) {
		this.mesTabelaReferencia = mesTabelaReferencia;
	}
}
