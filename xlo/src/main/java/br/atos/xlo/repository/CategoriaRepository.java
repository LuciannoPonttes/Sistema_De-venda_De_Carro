package br.atos.xlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.atos.xlo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query(value = "SELECT new Categoria(c.codigoCategoria, c.descricaoCategoria) FROM Categoria c"
			+ " WHERE LOWER(c.descricaoCategoria) LIKE CONCAT('%', LOWER(:desc), '%') OR :desc is null")
	List<Categoria> listarCategorias(@Param("desc") String descricao);
}
