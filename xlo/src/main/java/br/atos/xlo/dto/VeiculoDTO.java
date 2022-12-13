package br.atos.xlo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.model.Arquivo;
import br.atos.xlo.model.VeiculoItem;
import io.swagger.v3.oas.annotations.media.Schema;

public class VeiculoDTO {

	@Schema(description = "Código do Veículo", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private int codVeiculo;

	@Schema(description = "Descrição do Câmbio", example = "Automático", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String cambio;

	@Schema(description = "Ano do Veículo", example = "1994", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int anoVeiculo;

	@Schema(description = "Indicador de Garantia de Fabrica", example = "1", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int indicadorGarantiaFabrica;

	@Schema(description = "Quilometragem", example = "123456", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int numQuilometragem;

	@Schema(description = "Final da Placa", example = "9", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String placa;

	@Schema(description = "Valor do Veículo", example = "19330.27", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private BigDecimal valor;

	@Schema(description = "Status do Veículo", example = "1", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int statusVeiculo;

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dataInclusao;

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dataAtualizacao;

	@Schema(description = "Data da Venda", example = "1099-01-01T00:00:00.000Z", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@NotNull
	@NotBlank
	private Date dataVenda;

	@Schema(description = "Estado", example = "SP", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String estado;

	@Schema(description = "Cidade", example = "Osasco", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String cidade;

	@Schema(description = "Código da Categoria", example = "1", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int codigoCategoria;

	@Schema(description = "Código da Marca", example = "1", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int codigoMarca;

	@Schema(description = "Código do Modelo", example = "1", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int codigoModelo;

	@Schema(description = "Código do Modelo", example = "1", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private int codUsuario;

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private Set<VeiculoItemDTO> itemsVeiculo; 

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private Set<ArquivoDTO> arquivosVeiculo;

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

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public int getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(int codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	
	
	
}
