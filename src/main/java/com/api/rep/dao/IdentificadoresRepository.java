package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Identificadores;

/**
 * Interface de repositório dos Idendificadores do Rep
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface IdentificadoresRepository extends JpaRepository<Identificadores, Integer> {

}
