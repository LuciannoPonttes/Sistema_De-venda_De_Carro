package br.atos.xlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.atos.xlo.model.ReferenciaFipe;

public interface ReferenciaFipeRepository extends JpaRepository<ReferenciaFipe, Integer> {

	@Query(value = "SELECT max(ni_cod_ref) as ni_cod_ref FROM tb_referencia_fipe", nativeQuery = true)
	Integer buscaCodigoTabelaReferencia();
}
