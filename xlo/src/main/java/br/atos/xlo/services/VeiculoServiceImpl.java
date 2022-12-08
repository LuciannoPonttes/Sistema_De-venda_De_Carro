package br.atos.xlo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.repository.VeiculoRepository;


@Service
public class VeiculoServiceImpl implements VeiculoService{

	@Autowired
	VeiculoRepository veiculoRepository;
	
	
	@Override
	public VeiculoDTO adicionar(VeiculoDTO veiculoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeiculoDTO listar(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeiculoDTO excluir(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeiculoDTO editar(VeiculoDTO veiculoDTO) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
