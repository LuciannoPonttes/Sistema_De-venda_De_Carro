package br.atos.xlo.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.atos.xlo.enums.StatusUsuarioEnum;
import br.atos.xlo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "SELECT new Usuario(u.codUsuario, u.nome, u.cpf, u.email, u.statusUsuario, u.dtCadastro, u.dtAtualizacao)"
			+ " FROM Usuario u")
	Page<Usuario> listarUsuarios(Pageable pageable);

	@Query(value = "SELECT new Usuario(u.codUsuario, u.nome, u.cpf, u.email, u.statusUsuario, u.dtCadastro, u.dtAtualizacao)"
			+ " FROM Usuario u WHERE (u.statusUsuario = :status OR :status IS NULL)"
			+ " AND (u.dtCadastro BETWEEN COALESCE(:dataInicial, TO_DATE('0000-01-01', 'YYYY-MM-DD')) AND COALESCE(:dataFinal, TO_DATE('9999-12-31', 'YYYY-MM-DD')) )")
	Page<Usuario> relatorioUsuarios(@Param("status") StatusUsuarioEnum statusUsuario,
			@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal, Pageable pageable);
}
