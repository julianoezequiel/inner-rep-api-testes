package com.api.rep.rest.comandos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.ConfiguracaoService;

@RestController
public class ConfiguracacoesRestController extends ApiRestController {

	@Autowired
	private ConfiguracaoService configuracaoService;

	@RequestMapping(value = CONSTANTES.URL_CONFIG_SENHA, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigSenhas(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		this.configuracaoService.salvarSenhas(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_CONFIG_CARTOES, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigCartoes(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		this.configuracaoService.salvarCartoes(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_CONFIG_REDE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigRede(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		this.configuracaoService.salvarRede(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_RELOGIO, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigRelogio(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		
		this.configuracaoService.salvarRelogio(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = CONSTANTES.URL_CONFIG_HORARIO_VERAO, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigHorarioVerao(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		this.configuracaoService.salvarHorarioVerao(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = CONSTANTES.URL_BIOMETRIA_AJUSTES, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberAjustesBio(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		this.configuracaoService.salvarConfigBio(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = CONSTANTES.URL_CONFIG_WEB_SERVER, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigWebServer(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		this.configuracaoService.salvarConfigWebServe(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}


}
