package br.atos.xlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.atos.xlo.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

	@Query(value = "SELECT new Modelo(m.codigoModelo, m.descricaoModelo) FROM Modelo m"
			+ " WHERE LOWER(m.descricaoModelo) LIKE CONCAT('%', LOWER(:desc), '%') OR :desc is null")
	List<Modelo> listarModelos(@Param("desc") String descricao);
}
