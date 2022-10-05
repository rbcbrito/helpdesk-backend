package com.roberto.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberto.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
