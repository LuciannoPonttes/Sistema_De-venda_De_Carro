package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.CategoriaDTO;
import br.atos.xlo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CategoriaDTO> listar(String descricao) {
		return categoriaRepository.listarCategorias(descricao).stream().map(cat -> modelMapper.map(cat, CategoriaDTO.class))
				.collect(Collectors.toList());
	}

}
