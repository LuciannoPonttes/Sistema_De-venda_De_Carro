package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.CategoriaDTO;
import br.atos.xlo.model.Categoria;
import br.atos.xlo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CategoriaDTO adicionar(CategoriaDTO categoriaDTO) {
		categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
		return null;
	}
	
	@Override
	public List<CategoriaDTO> listar() {
		return categoriaRepository.findAll()
				.stream()
				.map(CategoriaDTO::from)
				.collect(Collectors.toList());
	}

	@Override
	public CategoriaDTO excluir(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaDTO editar(CategoriaDTO categoriaDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
