package br.atos.xlo.scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import br.atos.xlo.dto.CategoriaDTO;
import br.atos.xlo.dto.MarcaDTO;
import br.atos.xlo.dto.ModeloDTO;
import br.atos.xlo.dto.ReferenciaFipeDTO;
import br.atos.xlo.fipe.entidade.JsonFipe;
import br.atos.xlo.fipe.entidade.ModeloFipe;
import br.atos.xlo.fipe.entidade.TabelaReferenciaFipe;
import br.atos.xlo.services.CategoriaServiceImpl;
import br.atos.xlo.services.MarcaServiceImpl;
import br.atos.xlo.services.ModeloServiceImpl;
import br.atos.xlo.services.ReferenciaFipeServiceImpl;

@Component
public class FipeTask implements TaskService {

	private static final Logger logger = LogManager.getLogger(FipeTask.class);

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	MarcaServiceImpl marcaService;

	@Autowired
	ModeloServiceImpl modeloService;

	@Autowired
	CategoriaServiceImpl categoriaService;

	@Autowired
	ReferenciaFipeServiceImpl referenciaFipeService;

	@Value("${url.externa.fipe}")
	private String baseFipeURL;

	/**
	 * Método para carga de dados da Tabela Fipe.
	 * <p>
	 * Este método busca na API da Fipe para popular as marcas, modelos e valores da
	 * fipe.
	 */
	@Scheduled(cron = "0 * */10 * * *")
	public void executarTarefas() {
		Integer codigoTabelaReferencia = this.getCodigoTabelaReferencia();
		if (codigoTabelaReferencia == null) {
			this.obterTabelaReferencia();
		}

		List<CategoriaDTO> categorias = categoriaService.listar(null);
		for (CategoriaDTO categoriaDTO : categorias) {
			this.obterMarcas(categoriaDTO);
			this.obterModelos(categoriaDTO);
		}
	}

	/**
	 * Método para carregar Tabela de Referência da fipe, contendo seu código e mês
	 * referente.
	 * <p>
	 * Este método é executado no primeiro dia de cada mês.
	 */
	@Scheduled(cron = "0 * */1 1 * *")
	public void obterTabelaReferencia() {
		logger.info("Execução da obtenção da tabela de referencia - Início");
		String url = String.format("%s%s", baseFipeURL, "/ConsultarTabelaDeReferencia");

		ResponseEntity<Object[]> lista = executaRequisicao(url, null, HttpMethod.POST, Object[].class);

		List<TabelaReferenciaFipe> tabelaRef = null;
		try {
			tabelaRef = Arrays.asList(lista.getBody()).stream()
					.map(marca -> modelMapper.map(marca, TabelaReferenciaFipe.class)).collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Erro ao buscar tabela de referencia da fipe {}", e.getMessage());
		}

		if (tabelaRef != null)
			referenciaFipeService.adicionar(tabelaRef.stream()
					.map(t -> new ReferenciaFipeDTO(t.getCodigo(), t.getMes().trim())).collect(Collectors.toList()));
		else
			logger.error("Nenhuma tabela de referencia foi encontrada/adicionada");
		logger.info("Execução da obtenção da tabela de referencia - Final");
	}

	/**
	 * Método para carregar as Marcas de Veículos da Tabela fipe.
	 * 
	 * @param categoria categoria do veículo
	 */
	public void obterMarcas(CategoriaDTO categoria) {

		logger.info("Execução da obtenção das Marcas - Início");

		String url = String.format("%s%s", baseFipeURL, "/ConsultarMarcas");

		Integer codigoTabelaReferencia = this.getCodigoTabelaReferencia();
		if (codigoTabelaReferencia != null) {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

			map.add("codigoTabelaReferencia", String.valueOf(codigoTabelaReferencia));
			map.add("codigoTipoVeiculo", String.valueOf(categoria.getCodigoCategoria()));

			ResponseEntity<Object[]> lista = executaRequisicao(url, map, HttpMethod.POST, Object[].class);

			List<JsonFipe> marcas = null;
			try {
				marcas = Arrays.asList(lista.getBody()).stream().map(marca -> modelMapper.map(marca, JsonFipe.class))
						.collect(Collectors.toList());
			} catch (Exception e) {
				logger.error("Erro ao buscar marcas de veículos da fipe {}", e.getMessage());
			}

			if (marcas != null) {
				logger.info("Adicionando Marca da Categoria {}", categoria.getCodigoCategoria());
				marcaService.adicionarMarcas(marcas.stream()
						.map(marca -> new MarcaDTO(Integer.valueOf(marca.getValue()), marca.getLabel(), categoria))
						.collect(Collectors.toList()));
			} else
				logger.error("Nenhuma marca foi encontrada/adicionada");
		}
		logger.info("Execução da obtenção das Marcas - Final");
	}

	/**
	 * Método para carregar os Modelos de Veículos da Tabela fipe.
	 * 
	 * @param categoria categoria do veículo
	 */
	public void obterModelos(CategoriaDTO categoria) {

		logger.info("Execução da obtenção dos Modelos - Início");

		String url = String.format("%s%s", baseFipeURL, "/ConsultarModelos");
		Integer codigoTabelaReferencia = this.getCodigoTabelaReferencia();
		if (codigoTabelaReferencia != null) {

			List<MarcaDTO> marcas = marcaService.listar(null);

			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

			marcas.stream().forEach(itemMarca -> {
				map.clear();
				map.add("codigoTabelaReferencia", String.valueOf(codigoTabelaReferencia));
				map.add("codigoTipoVeiculo", String.valueOf(categoria.getCodigoCategoria()));
				map.add("codigoMarca", String.valueOf(itemMarca.getCodigoMarca()));

				ResponseEntity<Object> lista = executaRequisicao(url, map, HttpMethod.POST, Object.class);

				ModeloFipe modelosFipe = null;

				try {
					modelosFipe = modelMapper.map(lista.getBody(), ModeloFipe.class);
				} catch (Exception e) {
					logger.error("Erro ao buscar modelos de veículos da fipe {}", e.getMessage());
				}

				if (modelosFipe != null && modelosFipe.getModelos() != null) {
					logger.info("Adicionando modelo da Marca {}", itemMarca.getCodigoMarca());
					modeloService
							.adicionarModelos(
									modelosFipe.getModelos().stream()
											.map(modelo -> new ModeloDTO(Integer.valueOf(modelo.getValue()),
													modelo.getLabel(), itemMarca, categoria))
											.collect(Collectors.toList()));

				} else
					logger.error("Nenhum modelo foi encontrada/adicionado");
			});

		}
		logger.info("Execução da obtenção dos Modelos - Final");
	}

	/**
	 * Método para obter o código da tabela de referência mais recente.
	 */
	private Integer getCodigoTabelaReferencia() {
		return referenciaFipeService.buscaCodigoTabelaReferencia();
	}

	/**
	 * Método para executar a chamada para API externa.
	 */
	@Override
	public <T> ResponseEntity<T> executaRequisicao(String url, MultiValueMap<String, String> body,
			HttpMethod metodoHttp, Class<T> className) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

		return restTemplate.exchange(url, metodoHttp, entity, className);

	}

}
