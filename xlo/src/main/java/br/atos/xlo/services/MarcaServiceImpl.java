package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.MarcaDTO;
import br.atos.xlo.model.Marca;
import br.atos.xlo.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	MarcaRepository marcaRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<MarcaDTO> listar(String descricao) {
		return marcaRepository.listarMarcas(descricao).stream().map(modelo -> modelMapper.map(modelo, MarcaDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void adicionarMarca(MarcaDTO marcaDTO) {
		marcaRepository.save(modelMapper.map(marcaDTO, Marca.class));

	}

	public void adicionarMarcas(List<MarcaDTO> marcasDTO) {
		List<Marca> marcas = marcasDTO.stream().map(item -> modelMapper.map(item, Marca.class))
				.collect(Collectors.toList());
		marcaRepository.saveAll(marcas);

	}

}
