package br.atos.xlo.dto;

import br.atos.xlo.model.Arquivo;

public class ArquivoDTO {
	
	private int codigoArquivo;

	private String endArquivo;
	
	public ArquivoDTO(int codigoArquivo, String descricaoArquivo) {
		super();
		this.codigoArquivo = codigoArquivo;
		this.endArquivo = descricaoArquivo;
	}

	public int getCodigoArquivo() {
		return codigoArquivo;
	}

	public void setCodigoArquivo(int codigoArquivo) {
		this.codigoArquivo = codigoArquivo;
	}

	public ArquivoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricaoArquivo() {
		return endArquivo;
	}

	public void setDescricaoArquivo(String descricaoArquivo) {
		this.endArquivo = descricaoArquivo;
	}
	
	public static ArquivoDTO from(Arquivo arquivo) {
		return new ArquivoDTO(arquivo.getCodArquivo(), arquivo.getEndArquivo());
	}
	
}