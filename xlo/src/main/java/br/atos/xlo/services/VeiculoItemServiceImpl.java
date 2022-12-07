package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.VeiculoItemDTO;
import br.atos.xlo.repository.VeiculoItemRepository;

@Service
public class VeiculoItemServiceImpl implements VeiculoItemService {
	
	@Autowired
	private VeiculoItemRepository repository;
	
	@Override
	public List<VeiculoItemDTO> listar() {
		return repository.findAll()
				.stream()
				.map(VeiculoItemDTO::from)
				.collect(Collectors.toList());
	}

}
