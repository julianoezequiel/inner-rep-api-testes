package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Rep;

/**
 * Interface de repositório do Rep
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface RepRepository extends JpaRepository<Rep, Integer> {

	@Query(value = "select r from Rep r where r.numeroSerie =:pnumSerie")
	public Rep buscarPorNumeroSerie(@Param("pnumSerie") String numSerie);
}
