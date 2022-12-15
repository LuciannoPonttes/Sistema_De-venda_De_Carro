package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.UsuarioDTO;

public interface UsuarioService {

	public UsuarioDTO adicionar(UsuarioDTO usuarioDTO);
	public List<UsuarioDTO> listar(String nome);
	public void excluir(int id);
	public UsuarioDTO editar(UsuarioDTO usuarioDTO);

	
}
