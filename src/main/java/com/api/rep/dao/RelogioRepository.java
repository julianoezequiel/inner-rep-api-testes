package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Relogio;

/**
 * Interface de repositório do Relógio do Rep
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface RelogioRepository extends JpaRepository<Relogio, Integer> {

}
