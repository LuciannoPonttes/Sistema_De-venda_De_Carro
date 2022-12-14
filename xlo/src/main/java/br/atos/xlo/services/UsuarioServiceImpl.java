package br.atos.xlo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.LoginDTO;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.model.Endereco;
import br.atos.xlo.model.Usuario;
import br.atos.xlo.repository.EnderecoRepository;
import br.atos.xlo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	LoginServiceImpl loginService;

	@Override
	public UsuarioDTO adicionar(UsuarioDTO usuarioDTO) {

		LoginDTO login = usuarioDTO.getLogin();
		usuarioDTO.setLogin(null);

		Endereco end = modelMapper.map(usuarioDTO.getEndereco(), Endereco.class);

		usuarioDTO.setEndereco(null);

		Usuario usuario = usuarioRepository.save(modelMapper.map(usuarioDTO, Usuario.class));

		end.setUsuario(usuario);

		end = enderecoRepository.save(end);

		usuario.setEndereco(end);

		loginService.adicionar(login, modelMapper.map(usuario, UsuarioDTO.class));

		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	@Override
	public List<UsuarioDTO> listar(String nome) {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(user -> modelMapper.map(user, UsuarioDTO.class)).collect(Collectors.toList());
	}

	@Override
	public void excluir(int id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public UsuarioDTO editar(UsuarioDTO usuarioDTO) {

		usuarioDTO.setLogin(null);

		Endereco end = modelMapper.map(usuarioDTO.getEndereco(), Endereco.class);

		usuarioDTO.setEndereco(null);

		Usuario usuario = usuarioRepository.save(modelMapper.map(usuarioDTO, Usuario.class));

		end.setUsuario(usuario);

		end = enderecoRepository.save(end);

		usuario.setEndereco(end);

		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	@Override
	public Page<UsuarioDTO> listarUsuarios(Pageable pageable) {

		Page<Usuario> usuarios = usuarioRepository.listarUsuarios(pageable);

		return usuarios.map(user -> modelMapper.map(user, UsuarioDTO.class));

	}

}
