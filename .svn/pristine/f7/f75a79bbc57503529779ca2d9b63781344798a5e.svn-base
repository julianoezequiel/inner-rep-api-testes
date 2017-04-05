package com.api.rep.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.Empregado;
import com.api.rep.entity.Rep;

/**
 * Interface de repositório do empregado
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

	/**
	 * Consulta na base de dados um empregado polo pis e pelo Rep
	 * 
	 * @param pis
	 * @param idRep
	 * @return
	 */
	@Query(value = "select e from Empregado e where e.empregadoPis = :pis and (e.repId is null or e.repId = :idRep)")
	public Optional<Empregado> buscarPorPis(@Param("pis") String pis, @Param("idRep") Rep idRep);

	/**
	 * Exclui os empregados do Rep
	 * 
	 * @param rep
	 * @return
	 */
	@Transactional
	public long removeByrepId(Rep rep);
}
