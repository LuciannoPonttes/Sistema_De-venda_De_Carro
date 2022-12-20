package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.ModeloDTO;
import br.atos.xlo.model.Modelo;
import br.atos.xlo.repository.ModeloRepository;

@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	ModeloRepository modeloRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ModeloDTO> listar(String descricao) {
		return modeloRepository.listarModelos(descricao).stream().map(modelo -> modelMapper.map(modelo, ModeloDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void adicionar(ModeloDTO modeloDTO) {

		modeloRepository.save(modelMapper.map(modeloDTO, Modelo.class));
		
	}
	
}
