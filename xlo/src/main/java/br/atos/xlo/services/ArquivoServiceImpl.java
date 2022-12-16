package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.ArquivoDTO;
import br.atos.xlo.model.Arquivo;
import br.atos.xlo.repository.ArquivoRepository;

@Service
public class ArquivoServiceImpl implements ArquivoService {

	@Autowired
	ArquivoRepository arquivoRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ArquivoDTO adicionar(ArquivoDTO arquivoDTO) {
		arquivoRepository.save(modelMapper.map(arquivoDTO, Arquivo.class));
		return null;
	}

	@Override
	public List<ArquivoDTO> listar() {
		return arquivoRepository.findAll().stream().map(arq -> modelMapper.map(arq, ArquivoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ArquivoDTO excluir(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArquivoDTO editar(ArquivoDTO arquivoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
