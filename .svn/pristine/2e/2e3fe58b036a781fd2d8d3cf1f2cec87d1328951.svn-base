package com.api.rep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Tarefa;
import com.api.rep.entity.Rep;

/**
 * Interface de repositório das tarefas do Rep
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

	@Query(value = "select p from Tarefa p where p.repId = :prep")
	public List<Tarefa> buscarPorRep(@Param("prep") Rep rep);

	@Query(value = "select p from Tarefa p where p.id = :pnsu")
	public List<Tarefa> buscarPorNsu(@Param("pnsu") int nsu);

}
