package br.atos.xlo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.Body;
import br.atos.xlo.enums.StatusVeiculoEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public class VeiculoDTO implements Body {

	@Schema(description = "Código do Veículo", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int codVeiculo;

	@Schema(description = "Descrição do Câmbio", example = "Automático", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String cambio;

	@Schema(description = "Ano do Veículo", example = "1994", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	private int anoVeiculo;

	@Schema(description = "Indicador de Garantia de Fábrica", example = "1", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	private int indicadorGarantiaFabrica;

	@Schema(description = "Quilometragem", example = "123456", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	private int numQuilometragem;

	@Schema(description = "Final da Placa", example = "9", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String placa;

	@Schema(description = "Valor do Veículo", example = "19330.27", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	private BigDecimal valor;

	@Schema(description = "Status do Veículo", example = "1", required = true)
	@JsonView(value = { View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	private StatusVeiculoEnum statusVeiculo;

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	@Schema(description = "Data de inclusão", example = "1099-01-01T00:00:00.000Z", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dataInclusao;

	@Schema(description = "Data de atualização", example = "1099-01-01T00:00:00.000Z", required = true)
	@JsonView(value = { View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dataAtualizacao;

	@Schema(description = "Data da Venda", example = "1099-01-01T00:00:00.000Z", required = true)
	@JsonView(value = { View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dataVenda;

	@Schema(description = "Estado", example = "SP", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String estado;

	@Schema(description = "Cidade", example = "Osasco", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String cidade;

	@Schema(description = "Categoria do Veículo", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@Valid
	private CategoriaDTO categoria;

	@Schema(description = "Marca do Veículo", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@Valid
	private MarcaDTO marca;

	@Schema(description = "Modelo do Veículo", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	private ModeloDTO modelo;

	@Schema(description = "Código do Usuário", example = "'1'", required = true)
	@JsonView(value = { View.ControllerView.POST.class })
	@NotNull
	private int codUsuario;

	@Schema(description = "Usuário do Veículo", required = true)
	@JsonView(value = { View.ControllerView.Internal.class })
	private UsuarioDTO usuario;

	@Schema(description = "Itens do Veículo", required = true)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class, View.ControllerView.POST.class,
			View.ControllerView.Public.class })
	private Set<VeiculoItemDTO> itemsVeiculo;

	@Schema(description = "Arquivos do Veículo", required = true)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class, View.ControllerView.POST.class,
			View.ControllerView.Public.class })
	private Set<ArquivoDTO> arquivosVeiculo;

	public VeiculoDTO() {
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

	public StatusVeiculoEnum getStatusVeiculo() {
		return statusVeiculo;
	}

	public void setStatusVeiculo(StatusVeiculoEnum statusVeiculo) {
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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}

	public ModeloDTO getModelo() {
		return modelo;
	}

	public void setModelo(ModeloDTO modelo) {
		this.modelo = modelo;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public Set<VeiculoItemDTO> getItemsVeiculo() {
		return itemsVeiculo;
	}

	public void setItemsVeiculo(Set<VeiculoItemDTO> itemsVeiculo) {
		this.itemsVeiculo = itemsVeiculo;
	}

	public Set<ArquivoDTO> getArquivosVeiculo() {
		return arquivosVeiculo;
	}

	public void setArquivosVeiculo(Set<ArquivoDTO> arquivosVeiculo) {
		this.arquivosVeiculo = arquivosVeiculo;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}
