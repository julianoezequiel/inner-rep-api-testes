package com.api.rep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Empregador;

/**
 * Interface de repositório do empregador
 * @author juliano.ezequiel
 *
 */
@Repository
public interface EmpregadorRepository extends JpaRepository<Empregador, Integer> {

	/**
	 * 
	 * @param indentificador
	 * @return
	 */
	@Query(value = "Select e from Empregador e where e.empregadorIdent = :indentificador")
	public List<Empregador> buscarPorIndentificador(@Param("indentificador") String indentificador);
	
	
}
