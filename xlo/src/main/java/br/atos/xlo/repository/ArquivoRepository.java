package br.atos.xlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.xlo.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {

}
