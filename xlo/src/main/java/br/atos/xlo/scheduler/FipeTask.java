package br.atos.xlo.scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.atos.xlo.dto.MarcaDTO;
import br.atos.xlo.dto.MarcaDTOResponse;
import br.atos.xlo.dto.ModeloDTO;
import br.atos.xlo.dto.ModeloDTOResponse;
import br.atos.xlo.services.MarcaServiceImpl;
import br.atos.xlo.services.ModeloServiceImpl;

@Component
public class FipeTask {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	MarcaServiceImpl marcaService;

	@Autowired
	ModeloServiceImpl modeloService;
	
	@Value("${url.externa.fipe}")
	private String fipeURL;

	@Scheduled(cron = "*/30 * 22 * * *") // Todos os dias as 21 horas de 30 em 30 segundos
	public void executaTarefas() {
		obterMarcas();

		obterModelos();

	}

	public void obterMarcas() {

		System.out.println("Execução da obtenção das Marcas - Início");

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

		map.add("codigoTabelaReferencia", "291");
		map.add("codigoTipoVeiculo", "1");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		ResponseEntity<Object[]> lista = restTemplate.exchange(fipeURL + "ConsultarMarcas", HttpMethod.POST, entity,
				Object[].class);

		List<MarcaDTOResponse> marcas = Arrays.asList(lista.getBody()).stream()
				.map(marca -> modelMapper.map(marca, MarcaDTOResponse.class)).collect(Collectors.toList());

		for (MarcaDTOResponse item : marcas) {
			MarcaDTO marcaInclusao = new MarcaDTO();

			marcaInclusao.setCodigoMarca(Integer.parseInt(item.getValue()));
			marcaInclusao.setDescricaoMarca(item.getLabel());
			marcaService.adicionar(marcaInclusao);

			marcaInclusao = null;

		}
		System.out.println("Execução da obtenção das Marcas - Final");
	}

	@Scheduled(cron = "*/30 * 17 * * *") // Todos os dias as 21 horas de 30 em 30 segundos
	public void obterModelos() {

		System.out.println("Execução da obtenção das Marcas - Início");

		List<MarcaDTO> marcas = marcaService.listar(null);

		for (MarcaDTO itemMarca : marcas) {

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

			map.add("codigoTabelaReferencia", "291");
			map.add("codigoTipoVeiculo", "1");
			map.add("codigoMarca", Integer.toString(itemMarca.getCodigoMarca()));
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

			ResponseEntity<Object[]> lista = restTemplate.exchange(fipeURL + "ConsultarModelos", HttpMethod.POST,
					entity, Object[].class);

			List<ModeloDTOResponse> modelos = Arrays.asList(lista.getBody()).stream()
					.map(modelo -> modelMapper.map(modelo, ModeloDTOResponse.class)).collect(Collectors.toList());

			for (ModeloDTOResponse item : modelos) {
				ModeloDTO modeloInclusao = new ModeloDTO();

				modeloInclusao.setCodigoModelo(Integer.parseInt(item.getValue()));
				modeloInclusao.setDescricaoModelo(item.getLabel());
				modeloInclusao.setMarca(itemMarca);
				modeloService.adicionar(modeloInclusao);

				modeloInclusao = null;

			}
		}
		System.out.println("Execução da obtenção das Marcas - Final");
	}

}
