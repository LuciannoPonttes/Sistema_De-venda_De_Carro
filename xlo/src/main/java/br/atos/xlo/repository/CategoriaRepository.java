package br.atos.xlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.xlo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
