package br.atos.xlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.atos.xlo.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	
	@Query(value="SELECT * FROM TB_VEICULO ORDER BY DTH_INCLUSAO DESC LIMIT 10", nativeQuery=true)
	List<Veiculo> exibirUltimosAnuncios();
}
