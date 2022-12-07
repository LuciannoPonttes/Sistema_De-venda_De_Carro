package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.CategoriaDTO;
import br.atos.xlo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaRepository repository;
	
	@Override
	public List<CategoriaDTO> listar() {
		return repository.findAll()
				.stream()
				.map(CategoriaDTO::from)
				.collect(Collectors.toList());
	}

}
