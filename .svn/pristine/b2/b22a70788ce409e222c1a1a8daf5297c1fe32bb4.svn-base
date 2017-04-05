package com.api.rep.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.api.rep.entity.Rep;
import com.api.rep.service.rep.RepService;

@Component
public class MonitorStatusCom {

	public final static Logger LOGGER = LoggerFactory.getLogger(ApiService.class.getName());

	@Autowired
	private RepService repService;

	@Scheduled(fixedRate = 5000)
	public void init() {
		Collection<Rep> list = this.repService.buscarTodosRep();
		list.stream().forEach(rep -> atualizarStatus(rep));
	}

	private void atualizarStatus(Rep rep) {
		try{
		if (rep.getUltimaConexao() != null && rep.getConfiguracoesRedeId() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(rep.getUltimaConexao());
			c.add(Calendar.SECOND, rep.getConfiguracoesRedeId().getIntervaloCom() + 2);
			Date d = new Date();
			if (c.getTime().getTime() < d.getTime()) {
				rep.setStatus("OFF-LINE");
			} else {
				rep.setStatus("ON-LINE");
			}
		}
		this.repService.salvar(rep);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
