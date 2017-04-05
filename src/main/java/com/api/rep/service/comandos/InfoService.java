package com.api.rep.service.comandos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.dao.InfoRepository;
import com.api.rep.dto.comandos.InfoCmd;
import com.api.rep.entity.Info;
import com.api.rep.entity.Rep;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class InfoService extends ApiService {

	@Autowired
	private InfoRepository infoRepository;

	public void salvar(MultipartFile dados, Rep repAutenticado)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {

		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		InfoCmd infoCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), InfoCmd.class);
		LOGGER.info("Informações do Rep : " + this.getMapper().writeValueAsString(infoCmd));
		Info info = infoCmd.toInfo();
		info.setId(repAutenticado.getInfoId() != null ? repAutenticado.getInfoId().getId() : null);

		info = this.infoRepository.save(info);
		repAutenticado.setInfoId(info);
		repAutenticado.setUltimoNsr(new Integer(info.getUltimoNsr()));

		this.getRepService().salvar(repAutenticado);
		

	}
}
