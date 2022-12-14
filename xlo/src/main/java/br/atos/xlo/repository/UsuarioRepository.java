package br.atos.xlo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.atos.xlo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT * FROM TB_USUARIO", nativeQuery = true)
	Page<Usuario> listarUsuarios(Pageable pageable);

	
}
