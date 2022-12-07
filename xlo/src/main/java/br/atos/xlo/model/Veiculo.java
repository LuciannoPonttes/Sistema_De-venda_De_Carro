package br.atos.xlo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -6714671593349761910L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_VEICULO")
	private int codVeiculo;

	@Column(name = "VC_DESC_CAMBIO")
	private String cambio;

	@Column(name = "NI_ANO_VEICULO")
	private int anoVeiculo;

	@Column(name = "NI_IND_GARANTIA_FAB")
	private int indicadorGarantiaFabrica;

	@Column(name = "NI_NUM_QUILOMETRAGEM")
	private int numQuilometragem;

	@Column(name = "VC_DESC_PLACA")
	private String placa;

	@Column(name = "ND_VALOR")
	private BigDecimal valor;

	@Column(name = "NI_STATUS_VEICULO")
	private int statusVeiculo;

	@Column(name = "DTH_INCLUSAO")
	private Date dataInclusao;

	@Column(name = "DTH_ATUALIZACAO")
	private Date dataAtualizacao;

	@Column(name = "DTH_VENDA")
	private Date dataVenda;

	@Column(name = "VC_ESTADO")
	private String estado;

	@Column(name = "VC_CIDADE")
	private String cidade;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NI_COD_CATEGORIA", referencedColumnName = "NI_COD_CATEGORIA")
	private Categoria categoria;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NI_COD_MARCA", referencedColumnName = "NI_COD_MARCA")
	private Marca marca;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NI_COD_MODELO", referencedColumnName = "NI_COD_MODELO")
	private Modelo modelo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NI_COD_USUARIO", referencedColumnName = "NI_COD_USUARIO")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "TB_VEICULO_ITEM_VEIC", joinColumns = @JoinColumn(name = "NI_COD_VEICULO", referencedColumnName = "NI_COD_VEICULO"), inverseJoinColumns = @JoinColumn(name = "NI_COD_ITEM", referencedColumnName = "NI_COD_ITEM"))
	private List<VeiculoItem> itemsVeiculo = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "TB_VEICULO_ARQUIVO", joinColumns = @JoinColumn(name = "NI_COD_VEICULO", referencedColumnName = "NI_COD_VEICULO"), inverseJoinColumns = @JoinColumn(name = "NI_COD_ARQUIVO", referencedColumnName = "NI_COD_ARQUIVO"))
	private List<Arquivo> arquivosVeiculo = new ArrayList<>();

	public Veiculo() {
		super();
	}

	public int getCodVeiculo() {
		return codVeiculo;
	}

	public void setCodVeiculo(int codVeiculo) {
		this.codVeiculo = codVeiculo;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public int getAnoVeiculo() {
		return anoVeiculo;
	}

	public void setAnoVeiculo(int anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public int getIndicadorGarantiaFabrica() {
		return indicadorGarantiaFabrica;
	}

	public void setIndicadorGarantiaFabrica(int indicadorGarantiaFabrica) {
		this.indicadorGarantiaFabrica = indicadorGarantiaFabrica;
	}

	public int getNumQuilometragem() {
		return numQuilometragem;
	}

	public void setNumQuilometragem(int numQuilometragem) {
		this.numQuilometragem = numQuilometragem;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getStatusVeiculo() {
		return statusVeiculo;
	}

	public void setStatusVeiculo(int statusVeiculo) {
		this.statusVeiculo = statusVeiculo;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<VeiculoItem> getItemsVeiculo() {
		return itemsVeiculo;
	}

	public void setItemsVeiculo(List<VeiculoItem> itemsVeiculo) {
		this.itemsVeiculo = itemsVeiculo;
	}

	public List<Arquivo> getArquivosVeiculo() {
		return arquivosVeiculo;
	}

	public void setArquivosVeiculo(List<Arquivo> arquivosVeiculo) {
		this.arquivosVeiculo = arquivosVeiculo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
