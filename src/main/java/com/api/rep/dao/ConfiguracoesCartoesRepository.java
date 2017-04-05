package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.ConfiguracoesCartoes;

/**
 * Interface de repositório das configurações de cartões
 * 
 * @author juliano.ezequiel
 *
 */
@Repository
public interface ConfiguracoesCartoesRepository extends JpaRepository<ConfiguracoesCartoes, Integer> {

}
