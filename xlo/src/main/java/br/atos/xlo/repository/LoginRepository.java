package br.atos.xlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.xlo.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
