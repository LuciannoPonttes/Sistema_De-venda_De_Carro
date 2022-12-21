package br.atos.xlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_REFERENCIA_FIPE")
public class ReferenciaFipe {

	@Id
	@Column(name = "NI_COD_REF")
	private int codigoTabelaReferencia;

	@Column(name = "VC_MES_REF")
	private String mesTabelaReferencia;

	public ReferenciaFipe(int codigoTabelaReferencia, String mesTabelaReferencia) {
		super();
		this.codigoTabelaReferencia = codigoTabelaReferencia;
		this.mesTabelaReferencia = mesTabelaReferencia;
	}

	public ReferenciaFipe() {
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
