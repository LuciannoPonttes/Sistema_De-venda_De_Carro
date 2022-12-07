package br.atos.xlo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UsuarioDTO adicionar(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO listar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO excluir(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO editar(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
