package br.atos.xlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.xlo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
}
