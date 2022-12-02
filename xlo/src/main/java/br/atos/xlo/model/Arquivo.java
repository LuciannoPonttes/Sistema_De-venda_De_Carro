package br.atos.xlo.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity(name = "TB_ARQUIVO")
public class Arquivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_ARQUIVO")
	private int codArquivo;
	@Column(name = "VC_END_ARQUIVO")
	private String endArquivo;
	
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


}
