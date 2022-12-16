package br.atos.xlo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.atos.xlo.controller.request.RelatorioCustomQuery;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.enums.StatusUsuarioEnum;
import br.atos.xlo.model.Usuario;
import br.atos.xlo.model.Veiculo;
import br.atos.xlo.repository.UsuarioRepository;
import br.atos.xlo.repository.VeiculoRepository;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	VeiculoRepository veiculoRepository;

	@Autowired
	ModelMapper modelMapper;

	public Page<UsuarioDTO> gerarRelatorioUsuarios(RelatorioCustomQuery relatorioCustomQuery, Pageable pageable) {
		Page<Usuario> usuarios = usuarioRepository.relatorioUsuarios(
				StatusUsuarioEnum.fromValue(String.valueOf(relatorioCustomQuery.getSituacao())),
				relatorioCustomQuery.getDataInicial(), relatorioCustomQuery.getDataFinal(), pageable);

		return usuarios.map(user -> modelMapper.map(user, UsuarioDTO.class));
	}

	@Override
	public Page<VeiculoDTO> gerarRelatorioVeiculos(RelatorioCustomQuery relatorioCustomQuery, Pageable pageable) {

		Page<Veiculo> veiculos = veiculoRepository.relatorioVeiculos(pageable);
		
		return veiculos.map(veiculo -> modelMapper.map(veiculo, VeiculoDTO.class));
	}
}
