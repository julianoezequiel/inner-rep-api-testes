package com.api.rep.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Nsr;
import com.api.rep.entity.Rep;

/**
 * Interface de repositório dos NSR do Rep
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface NsrRepository extends JpaRepository<Nsr, Integer> {

	@Query(value = "select n from Nsr n where n.repId =:prep")
	public List<Nsr> buscarPorRep(@Param("prep") Rep rep, Pageable pageable);

	default List<Nsr> buscarUltimo(Rep rep) {
		return buscarPorRep(rep, new PageRequest(0, 1));
	}

	@Query(value = "select * from Nsr where rep_id = :id order by numero_nsr desc LIMIT 1", nativeQuery = true)
	public Nsr buscarUltimoNsr(@Param("id") Integer id);

	@Query(value = "select * from Nsr where rep_id = :id and numero_nsr = :numNsr",nativeQuery = true)
	public Nsr buscarPorNumNsr(@Param("id") Integer id, @Param("numNsr") Integer numNsr);

	@Query(value = "select n from Nsr n where n.repId = :prep")
	public List<Nsr> buscarPorRep(@Param("prep") Rep rep);

	@Transactional
	public long removeByrepId(Rep rep);

}
