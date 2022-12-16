package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.VeiculoItemDTO;
import br.atos.xlo.model.VeiculoItem;
import br.atos.xlo.repository.VeiculoItemRepository;

@Service
public class VeiculoItemServiceImpl implements VeiculoItemService {
	
	@Autowired
	VeiculoItemRepository veiculoItemRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public VeiculoItemDTO adicionar(VeiculoItemDTO veiculoItemDTO) {
		veiculoItemRepository.save(modelMapper.map(veiculoItemDTO, VeiculoItem.class));
		return null;
	}
	
	@Override
	public List<VeiculoItemDTO> listar() {
		return veiculoItemRepository.findAll()
				.stream()
				.map(VeiculoItemDTO::from)
				.collect(Collectors.toList());
	}

	@Override
	public VeiculoItemDTO excluir(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeiculoItemDTO editar(VeiculoItemDTO veiculoItemDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
