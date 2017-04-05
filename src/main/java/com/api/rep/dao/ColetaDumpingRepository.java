package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.ColetaDumping;

/**
 * Interface de repositório da coleta por dump
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface ColetaDumpingRepository extends JpaRepository<ColetaDumping, Integer> {

}
