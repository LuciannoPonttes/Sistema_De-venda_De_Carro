package br.atos.xlo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.atos.xlo.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	
	@Query(value="SELECT * FROM TB_VEICULO WHERE NI_STATUS_VEICULO = :status OR :status is null ORDER BY DTH_INCLUSAO DESC", nativeQuery = true)
	Page<Veiculo> listarVeiculosPaginados( @Param("status") Integer status, Pageable pageable);
	
	
	@Query(value="SELECT new Veiculo(v.codVeiculo) FROM Veiculo v")
	Page<Veiculo> relatorioVeiculos(Pageable pageable);

}
