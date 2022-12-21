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
		return modeloRepository.listarModelos(descricao).stream()
				.map(modelo -> modelMapper.map(modelo, ModeloDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ModeloDTO adicionarModelo(ModeloDTO modeloDTO) {
		return modelMapper.map(modeloRepository.save(modelMapper.map(modeloDTO, Modelo.class)), ModeloDTO.class);
	}

	@Override
	public List<ModeloDTO> adicionarModelos(List<ModeloDTO> modelosDTO) {
		List<Modelo> modelos = modelosDTO.stream().map(item -> modelMapper.map(item, Modelo.class))
				.collect(Collectors.toList());
		return modeloRepository.saveAll(modelos).stream().map(m -> modelMapper.map(m, ModeloDTO.class))
				.collect(Collectors.toList());
	}

}
