package com.api.rep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rep.entity.ConfiguracoesWebServer;

/**
 * Interface de repositório das configurações do webserve
 * @author juliano.ezequiel
 *
 */
@Repository
public interface ConfiguracoesWebServerRepository extends JpaRepository<ConfiguracoesWebServer, Integer> {

}
