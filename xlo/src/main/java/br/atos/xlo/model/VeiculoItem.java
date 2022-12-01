package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_VEIC")
public class VeiculoItem implements Serializable {

	private static final long serialVersionUID = 7321408371181501785L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_ITEM")
	private int codigoItem;

	@Column(name = "VC_DESC_ITEM")
	private String descricaoItem;

	@Column(name = "NI_STATUS_REGISTRO")
	private int statusRegistro;

	public VeiculoItem() {
		super();
	}

	public int getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(int codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public int getStatusRegistro() {
		return statusRegistro;
	}

	public void setStatusRegistro(int statusRegistro) {
		this.statusRegistro = statusRegistro;
	}

	@Override
	public String toString() {
		return "VeiculoItem [codigoItem=" + codigoItem + ", descricaoItem=" + descricaoItem + ", statusRegistro="
				+ statusRegistro + "]";
	}

}
