package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Coleta;

/**
 * Interface de repositório da coleta
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Integer> {

}
