package br.atos.xlo.services;

import java.util.List;

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
import br.atos.xlo.repository.UsuarioRepository;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ModelMapper modelMapper;

	public Page<UsuarioDTO> gerarRelatorioUsuarios(RelatorioCustomQuery relatorioCustomQuery, Pageable pageable) {
		Page<Usuario> usuarios = usuarioRepository.relatorioUsuarios(
				StatusUsuarioEnum.fromValue(String.valueOf(relatorioCustomQuery.getSituacao())),
				relatorioCustomQuery.getDataInicial(), relatorioCustomQuery.getDataFinal(), pageable);

		return usuarios.map(user -> modelMapper.map(user, UsuarioDTO.class));
	}

	@Override
	public List<VeiculoDTO> gerarRelatorioVeiculos(RelatorioCustomQuery relatorioCustomQuery) {

		return null;
	}
}
