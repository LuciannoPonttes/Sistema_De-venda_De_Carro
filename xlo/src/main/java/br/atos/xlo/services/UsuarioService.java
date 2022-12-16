package br.atos.xlo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.atos.xlo.dto.UsuarioDTO;

public interface UsuarioService {

	public UsuarioDTO adicionar(UsuarioDTO usuarioDTO);
	public List<UsuarioDTO> listar(String nome);
	public void excluir(int id);
	public UsuarioDTO editar(UsuarioDTO usuarioDTO);
	public Page<UsuarioDTO> listarUsuarios(Pageable pageable);

	
}
