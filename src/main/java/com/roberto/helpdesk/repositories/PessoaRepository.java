package com.roberto.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberto.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
