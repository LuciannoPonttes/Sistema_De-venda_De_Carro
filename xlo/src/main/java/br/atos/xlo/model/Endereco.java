package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity(name = "TB_ENDERECO")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_ENDERECO")
	private int codEndereco;
	@Column(name = "VC_CEP")
	private String cep;
	@Column(name = "VC_LOGRADOURO")
	private String logradouro;
	@Column(name = "VC_BAIRRO")
	private String bairro;
	@Column(name = "VC_CIDADE")
	private String cidade;
	@Column(name = "VC_ESTADO")
	private String estado;
	@Column(name = "NI_NUMERO")
	private int numero;
	@Column(name = "VC_COMPLEMENTO")
	private String complemento;
	
	public int getCod_endereco() {
		return codEndereco;
	}
	public void setCod_endereco(int cod_endereco) {
		this.codEndereco = cod_endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	

}
