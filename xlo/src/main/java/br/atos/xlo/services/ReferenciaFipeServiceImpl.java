package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.ReferenciaFipeDTO;
import br.atos.xlo.model.ReferenciaFipe;
import br.atos.xlo.repository.ReferenciaFipeRepository;

@Service
public class ReferenciaFipeServiceImpl implements ReferenciaFipeService {

	@Autowired
	ReferenciaFipeRepository referenciaRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ReferenciaFipeDTO> adicionar(List<ReferenciaFipeDTO> referenciaFipeDTO) {

		return referenciaRepository.saveAll(referenciaFipeDTO.stream().map(rf -> modelMapper.map(rf, ReferenciaFipe.class))
				.collect(Collectors.toList())).stream().map(rf -> modelMapper.map(rf, ReferenciaFipeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Integer buscaCodigoTabelaReferencia() {
		return referenciaRepository.buscaCodigoTabelaReferencia();
	}

}
