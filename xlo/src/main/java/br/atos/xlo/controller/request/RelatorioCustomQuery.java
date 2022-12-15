package br.atos.xlo.controller.request;

import java.util.Date;

public class RelatorioCustomQuery {

	private int categoria;

	private int situacao;

	private Date dataInicial;

	private Date dataFinal;

	public RelatorioCustomQuery(int categoria, int situacao, Date dataInicial, Date dataFinal) {
		super();
		this.categoria = categoria;
		this.situacao = situacao;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public RelatorioCustomQuery(int situacao, Date dataInicial, Date dataFinal) {
		super();
		this.situacao = situacao;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
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
