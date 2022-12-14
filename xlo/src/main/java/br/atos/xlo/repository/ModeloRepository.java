package br.atos.xlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.atos.xlo.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

	@Query(value = "SELECT NI_COD_MODELO, VC_DESC_MODELO FROM TB_MODELO", nativeQuery = true)
	List<Modelo> listarModelos();
}
