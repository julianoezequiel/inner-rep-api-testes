package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.ConfiguracoesSenha;

/**
 * Interface de repositório das configurações de Senha
 * @author juliano.ezequiel
 *
 */
@Repository
public interface ConfiguracoesSenhaRepository extends JpaRepository<ConfiguracoesSenha, Integer> {

	
}
