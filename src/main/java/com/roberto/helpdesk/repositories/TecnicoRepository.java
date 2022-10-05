package com.roberto.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberto.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
