package br.atos.xlo.controller.dto.base.response;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;

public class ResponseNodePagination<T extends Body> {

	@JsonView(value = { View.ControllerView.Public.class })
	int status;

	@JsonView(value = { View.ControllerView.Public.class })
	int numPagina;

	@JsonView(value = { View.ControllerView.Public.class })
	int tamPagina;

	@JsonView(value = { View.ControllerView.Public.class })
	int totalPaginas;

	@JsonView(value = { View.ControllerView.Public.class })
	int totalRetornado;

	@JsonView(value = { View.ControllerView.Public.class })
	long totalEncontrado;

	@JsonView(value = { View.ControllerView.Public.class })
	List<T> conteudo;

	public ResponseNodePagination() {

	}

	public ResponseNodePagination(HttpStatus status, Page<T> page) {
		this.status = status.value();
		this.numPagina = page.getPageable().getPageNumber();
		this.tamPagina = page.getPageable().getPageSize();
		this.totalPaginas = page.getTotalPages();
		this.totalRetornado = page.getNumberOfElements();
		this.totalEncontrado = page.getTotalElements();
		this.conteudo = page.getContent();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}

	public int getTamPagina() {
		return tamPagina;
	}

	public void setTamPagina(int tamPagina) {
		this.tamPagina = tamPagina;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public int getTotalRetornado() {
		return totalRetornado;
	}

	public void setTotalRetornado(int totalRetornado) {
		this.totalRetornado = totalRetornado;
	}

	public long getTotalEncontrado() {
		return totalEncontrado;
	}

	public void setTotalEncontrado(long totalEncontrado) {
		this.totalEncontrado = totalEncontrado;
	}

	public List<T> getConteudo() {
		return conteudo;
	}

	public void setConteudo(List<T> conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "ResponseNodePagination [status=" + status + ", numPagina=" + numPagina + ", tamPagina=" + tamPagina
				+ ", totalPaginas=" + totalPaginas + ", totalRetornado=" + totalRetornado + ", totalEncontrado="
				+ totalEncontrado + ", conteudo=" + conteudo + "]";
	}

}