package br.atos.xlo.dto;

import br.atos.xlo.model.Categoria;

public class CategoriaDTO {
	
	private int codigoCategoria;

	private String descricaoCategoria;
	
	public CategoriaDTO(int codigoCategoria, String descricaoCategoria) {
		super();
		this.codigoCategoria = codigoCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	
	public static CategoriaDTO from(Categoria categoria) {
		return new CategoriaDTO(categoria.getCodigoCategoria(), categoria.getDescricaoCategoria());
	}
	
}
