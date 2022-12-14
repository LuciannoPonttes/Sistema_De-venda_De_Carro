package br.atos.xlo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.atos.xlo.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	
	@Query(value="SELECT ND_VALOR FROM TB_VEICULO WHERE NI_STATUS_VEICULO = ?1 ORDER BY DTH_INCLUSAO DESC", nativeQuery = true)
	Page<Veiculo> listarVeiculosPaginados(Integer status, Pageable pageable);
}
