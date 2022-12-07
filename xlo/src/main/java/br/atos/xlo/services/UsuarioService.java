package br.atos.xlo.services;

import br.atos.xlo.dto.UsuarioDTO;

public interface UsuarioService {

	public UsuarioDTO adicionar(UsuarioDTO usuarioDTO);
	public UsuarioDTO listar(String nome);
	public UsuarioDTO excluir(Long id);
	public UsuarioDTO editar(UsuarioDTO usuarioDTO);

	
}
