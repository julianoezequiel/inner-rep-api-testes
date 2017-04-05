package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.HorarioVerao;

/**
 * Interface de repositório das configurações do horário de verão
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface HorarioVeraoRepository extends JpaRepository<HorarioVerao, Integer> {

}
