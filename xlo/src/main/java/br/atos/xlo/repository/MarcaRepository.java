package br.atos.xlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.atos.xlo.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

	@Query(value = "SELECT NI_COD_MARCA, VC_DESC_MARCA FROM TB_MARCA", nativeQuery = true)
	List<Marca> listarMarcas();
}
