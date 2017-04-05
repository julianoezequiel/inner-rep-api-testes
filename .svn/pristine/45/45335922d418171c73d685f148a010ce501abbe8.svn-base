package com.api.rep.rest.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comandos.AjustesBioCmd;
import com.api.rep.dto.comandos.ConfiguracaoSenhaCmd;
import com.api.rep.dto.comandos.ConfiguracoesCartoesCmd;
import com.api.rep.dto.comandos.ConfiguracoesRedeCmd;
import com.api.rep.dto.comandos.ConfiguracacoesWebServerCmd;
import com.api.rep.dto.comandos.HorarioVeraoCmd;
import com.api.rep.dto.comandos.RelogioCmd;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.ConfiguracaoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ConfiguracacoesRestController extends ApiRestController {

	@Autowired
	private ConfiguracaoService configuracaoService;

	@RequestMapping(value = CONSTANTES.URL_CONFIG_SENHA, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigSenhas(@RequestBody ConfiguracaoSenhaCmd configuracaoSenhaCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Configurações de Rede : " + this.getMapper().writeValueAsString(configuracaoSenhaCmd));
		this.configuracaoService.salvar(configuracaoSenhaCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_CONFIG_CARTOES, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigCartoes(@RequestBody ConfiguracoesCartoesCmd configuracoesCartoesCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Configurações de cartões : " + this.getMapper().writeValueAsString(configuracoesCartoesCmd));
		this.configuracaoService.salvar(configuracoesCartoesCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_CONFIG_REDE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigRede(@RequestBody ConfiguracoesRedeCmd configuracoesRedeCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Configurações de Rede : " + this.getMapper().writeValueAsString(configuracoesRedeCmd));
		this.configuracaoService.salvar(configuracoesRedeCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_RELOGIO, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigRelogio(@RequestBody RelogioCmd relogioCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Relógio : " + this.getMapper().writeValueAsString(relogioCmd));
		this.configuracaoService.salvar(relogioCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_CONFIG_HORARIO_VERAO, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigHorarioVerao(@RequestBody HorarioVeraoCmd horarioVeraoCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Horário verão : " + this.getMapper().writeValueAsString(horarioVeraoCmd));
		this.configuracaoService.salvar(horarioVeraoCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = CONSTANTES.URL_BIOMETRIA_AJUSTES, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberAjustesBio(@RequestBody AjustesBioCmd ajustesBioCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Horário verão : " + this.getMapper().writeValueAsString(ajustesBioCmd));
		this.configuracaoService.salvar(ajustesBioCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = CONSTANTES.URL_CONFIG_WEB_SERVER, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigWebServer(@RequestBody ConfiguracacoesWebServerCmd configuracacoesWebServerCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Horário verão : " + this.getMapper().writeValueAsString(configuracacoesWebServerCmd));
		this.configuracaoService.salvar(configuracacoesWebServerCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}


}
