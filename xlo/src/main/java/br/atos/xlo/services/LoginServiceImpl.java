package br.atos.xlo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.LoginDTO;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.model.Login;
import br.atos.xlo.model.Usuario;
import br.atos.xlo.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	ModelMapper modelMapper;

	public LoginDTO adicionar(LoginDTO loginDTO, UsuarioDTO usuarioDTO) {
		Login login = new Login();
		login.setNomeUsuario(loginDTO.getNomeUsuario());
		login.setUsuario(modelMapper.map(usuarioDTO, Usuario.class));
		login.setSenha(this.generatePassword(loginDTO.getSenha()));

		return modelMapper.map(loginRepository.save(login), LoginDTO.class);
	}

	public String generatePassword(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	public boolean verifyPassword(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
