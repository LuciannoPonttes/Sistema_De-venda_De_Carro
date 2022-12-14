package br.atos.xlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.atos.xlo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query(value = "SELECT NI_COD_CATEGORIA, VC_DESC_CATEGORIA FROM TB_CATEGORIA", nativeQuery = true)
	List<Categoria> listarCategorias();
}
