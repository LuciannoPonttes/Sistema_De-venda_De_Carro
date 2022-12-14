package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.ModeloDTO;
import br.atos.xlo.repository.ModeloRepository;

@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	ModeloRepository modeloRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ModeloDTO> listar() {
		return modeloRepository.listarModelos().stream().map(modelo -> modelMapper.map(modelo, ModeloDTO.class))
				.collect(Collectors.toList());
	}

}
