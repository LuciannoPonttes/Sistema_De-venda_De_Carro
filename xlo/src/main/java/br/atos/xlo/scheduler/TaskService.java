package br.atos.xlo.scheduler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public interface TaskService {

	public <T> ResponseEntity<T> executaRequisicao(String url, MultiValueMap<String, String> body,
			HttpMethod metodoHttp, Class<T> className);
}
