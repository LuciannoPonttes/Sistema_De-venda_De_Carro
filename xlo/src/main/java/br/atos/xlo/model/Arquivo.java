package br.atos.xlo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ARQUIVO")
public class Arquivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NI_COD_ARQUIVO")
	private int codArquivo;
	@Column(name = "VC_END_ARQUIVO")
	private String endArquivo;

	@ManyToMany(mappedBy = "arquivosVeiculo")
	private List<Veiculo> veiculos = new ArrayList<>();

	public int getCodArquivo() {
		return codArquivo;
	}

	public void setCodArquivo(int codArquivo) {
		this.codArquivo = codArquivo;
	}

	public String getEndArquivo() {
		return endArquivo;
	}

	public void setEndArquivo(String endArquivo) {
		this.endArquivo = endArquivo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
