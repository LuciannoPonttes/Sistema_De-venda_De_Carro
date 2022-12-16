package br.atos.xlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.atos.xlo.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

	@Query(value = "SELECT new Marca(m.codigoMarca, m.descricaoMarca) FROM Marca m"
			+ " WHERE LOWER(m.descricaoMarca) LIKE CONCAT('%', LOWER(:desc), '%') OR :desc is null")
	List<Marca> listarMarcas(@Param("desc") String descricao);
}
