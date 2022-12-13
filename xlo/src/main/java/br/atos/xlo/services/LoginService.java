package br.atos.xlo.services;

import br.atos.xlo.dto.LoginDTO;
import br.atos.xlo.dto.UsuarioDTO;

public interface LoginService {

	public LoginDTO adicionar(LoginDTO loginDTO, UsuarioDTO usuarioDTO);

	public String generatePassword(String rawPassword);
}
