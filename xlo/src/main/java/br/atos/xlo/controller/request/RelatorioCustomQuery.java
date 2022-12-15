package br.atos.xlo.controller.request;

import java.util.Date;

public class RelatorioCustomQuery {

	private Integer categoria;

	private Integer situacao;

	private Date dataInicial;

	private Date dataFinal;

	public RelatorioCustomQuery(Integer categoria, Integer situacao, Date dataInicial, Date dataFinal) {
		super();
		this.categoria = categoria;
		this.situacao = situacao;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public RelatorioCustomQuery(Integer situacao, Date dataInicial, Date dataFinal) {
		super();
		this.situacao = situacao;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

}
