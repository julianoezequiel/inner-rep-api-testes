package com.api.rep.service.comandos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES.TIPO_OPERACAO;
import com.api.rep.dao.AjusteBioRepository;
import com.api.rep.dao.ConfiguracoesCartoesRepository;
import com.api.rep.dao.ConfiguracoesRedeRepository;
import com.api.rep.dao.ConfiguracoesSenhaRepository;
import com.api.rep.dao.ConfiguracoesWebServerRepository;
import com.api.rep.dao.HorarioVeraoRepository;
import com.api.rep.dao.RelogioRepository;
import com.api.rep.dto.comandos.AjustesBioCmd;
import com.api.rep.dto.comandos.ConfiguracacoesWebServerCmd;
import com.api.rep.dto.comandos.ConfiguracaoSenhaCmd;
import com.api.rep.dto.comandos.ConfiguracoesCartoesCmd;
import com.api.rep.dto.comandos.ConfiguracoesRedeCmd;
import com.api.rep.dto.comandos.HorarioVeraoCmd;
import com.api.rep.dto.comandos.RelogioCmd;
import com.api.rep.dto.comunicacao.StatusDTO;
import com.api.rep.entity.AjustesBio;
import com.api.rep.entity.ConfiguracoesCartoes;
import com.api.rep.entity.ConfiguracoesRede;
import com.api.rep.entity.ConfiguracoesSenha;
import com.api.rep.entity.ConfiguracoesWebServer;
import com.api.rep.entity.HorarioVerao;
import com.api.rep.entity.Relogio;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ConfiguracaoService extends ApiService {

	@Autowired
	private ConfiguracoesRedeRepository configuracoesRedeRepository;

	@Autowired
	private ConfiguracoesCartoesRepository configuracoesCartoesRepository;

	@Autowired
	private ConfiguracoesSenhaRepository configuracoesSenhaRepository;

	@Autowired
	private RelogioRepository relogioRepository;

	@Autowired
	private HorarioVeraoRepository horarioVeraoRepository;

	@Autowired
	private AjusteBioRepository ajusteBioRepository;

	@Autowired
	private ConfiguracoesWebServerRepository configuracoesWebServerRepository;

	/**
	 * Salva em base as configurações de Senha
	 * 
	 * @param configuracaoSenhaCmd
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void salvarSenhas(MultipartFile dados, Rep repAutenticado) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		ConfiguracaoSenhaCmd configuracaoSenhaCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), ConfiguracaoSenhaCmd.class);
		LOGGER.info("Configurações de Rede : " + this.getMapper().writeValueAsString(configuracaoSenhaCmd));
		ConfiguracoesSenha configuracoesSenha = configuracaoSenhaCmd.toConfigurcacoesSenha();
		configuracoesSenha.setId(repAutenticado.getConfiguracoesSenhaId() != null
				? repAutenticado.getConfiguracoesSenhaId().getId() : null);
		this.configuracoesSenhaRepository.save(configuracoesSenha);

	}

	/**
	 * Salva em base as configurações de Cartões
	 * 
	 * @param configuracoesCartoesCmd
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void salvarCartoes(MultipartFile dados, Rep repAutenticado) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		ConfiguracoesCartoesCmd configuracoesCartoesCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), ConfiguracoesCartoesCmd.class);
		LOGGER.info("Configurações de cartões : " + this.getMapper().writeValueAsString(configuracoesCartoesCmd));
		ConfiguracoesCartoes configuracoesCartoes = configuracoesCartoesCmd.toConfiguracoesCartoes();
		configuracoesCartoes.setId(repAutenticado.getConfiguracoesCartoesId() != null
				? repAutenticado.getConfiguracoesCartoesId().getDigitosFixo() : null);
		this.configuracoesCartoesRepository.save(configuracoesCartoes);

	}

	/**
	 * Salva em base as configurações de Rede
	 * 
	 * @param configuracoesRedeCmd
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void salvarRede(MultipartFile dados, Rep repAutenticado) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		ConfiguracoesRedeCmd configuracoesRedeCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), ConfiguracoesRedeCmd.class);
		LOGGER.info("Configurações de Rede : " + this.getMapper().writeValueAsString(configuracoesRedeCmd));
		ConfiguracoesRede configuracoesRede = configuracoesRedeCmd.toConfiguracoesRede();
		configuracoesRede.setId(repAutenticado.getConfiguracoesRedeId() != null
				? repAutenticado.getConfiguracoesRedeId().getId() : null);
		this.configuracoesRedeRepository.save(configuracoesRede);

	}

	/**
	 * Salva em base o relógio(horário) do Rep
	 * 
	 * @param relogioCmd
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void salvarRelogio(MultipartFile dados, Rep repAutenticado) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		RelogioCmd  relogioCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), RelogioCmd.class);
		LOGGER.info("Relógio : " + this.getMapper().writeValueAsString(relogioCmd));
		Relogio relogio = relogioCmd.toRelogio();
		relogio.setId(repAutenticado.getRelogioId() != null ? repAutenticado.getRelogioId().getId() : null);
		this.relogioRepository.save(relogio);

	}

	/**
	 * Salva em base as configurações de Horário de verão
	 * 
	 * @param horarioVeraoCmd
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void salvarHorarioVerao(MultipartFile dados, Rep repAutenticado) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		HorarioVeraoCmd  horarioVeraoCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), HorarioVeraoCmd.class);
		LOGGER.info("Horário verão : " + this.getMapper().writeValueAsString(horarioVeraoCmd));
		HorarioVerao horarioVerao = horarioVeraoCmd.toHorarioVerao();
		horarioVerao
				.setId(repAutenticado.getHorarioVeraoId() != null ? repAutenticado.getHorarioVeraoId().getId() : null);
		this.horarioVeraoRepository.save(horarioVerao);
	}

	/**
	 * Salva em base as configurações de ajustes biométricos
	 * 
	 * @param ajustesBioCmd
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void salvarConfigBio(MultipartFile dados, Rep repAutenticado) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		AjustesBioCmd  ajustesBioCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), AjustesBioCmd.class);
		LOGGER.info("Ajustes bio : " + this.getMapper().writeValueAsString(ajustesBioCmd));
		AjustesBio ajustesBio = ajustesBioCmd.toAjustesBio();
		ajustesBio.setId(repAutenticado.getAjustesBioId() != null ? repAutenticado.getAjustesBioId().getId() : null);
		this.ajusteBioRepository.save(ajustesBio);

	}

	/**
	 * Salva em base as configurações do web Server
	 * 
	 * @param configuracacoesWebServerCmd
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void salvarConfigWebServe(MultipartFile dados, Rep repAutenticado) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		ConfiguracacoesWebServerCmd configuracacoesWebServerCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), ConfiguracacoesWebServerCmd.class);
		LOGGER.info("Config Web Server : " + this.getMapper().writeValueAsString(configuracacoesWebServerCmd));
		ConfiguracoesWebServer configuracoesWebServer = configuracacoesWebServerCmd.toConfigurcacoesWebServer();
		configuracoesWebServer.setId(repAutenticado.getConfiguracoesWebServerId() != null
				? repAutenticado.getConfiguracoesWebServerId().getId() : null);
		this.configuracoesWebServerRepository.save(configuracoesWebServer);

	}

	/**
	 * Vaerifica se ocorreu alguma alteração nas configurações do Rep
	 * 
	 * @param rep
	 * @param status
	 */
	public void validarAlteracoesConfiguracoes(Rep rep, StatusDTO status) {

		for (int i = 0; i < 8; i++) {
			// realiza um bitwise para verificar se ocorreu alterações
			// ALTEROU_NENHUM = 0x00,
			// ALTEROU_CONFIG_BIO = 0x01,
			// ALTEROU_CONFIG_SENHA = 0x02,
			// ALTEROU_CONFIG_REDE = 0x04,
			// ALTEROU_CONFIG_CARTOES = 0x08,
			// ALTEROU_CONFIG_HORARIO_VERAO= 0x10,
			// ALTEROU_CONFIG_RELOGIO = 0x20,
			// ALTEROU_CONFIG_WEB_SERVER= 0x40,
			if (((status.getConfig() >> i) & 1) == 1) {
				switch (i) {
				case 0:
					this.receberConfigAjustesBio(rep);
					break;
				case 1:
					this.receberConfigSenhas(rep);
					break;
				case 2:
					this.receberConfigRede(rep);
					break;
				case 3:
					this.receberConfigCartoes(rep);
					break;
				case 4:
					this.receberConfigHorarioVerao(rep);
					break;
				case 5:
					this.receberConfigRelogio(rep);
					break;
				case 6:
					this.receberConfigWebServer(rep);
					break;

				}
			}
		}
	}

	/**
	 * Agenda uma tarefa para receber as Configurações de Senha
	 * 
	 * @param rep
	 */
	public void receberConfigSenhas(Rep rep) {

		Tarefa tarefa = new Tarefa();
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_SENHA.ordinal());
		tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());

		if (rep.getConfiguracoesSenhaId() != null) {
			tarefa.setConfiguracoesSenhaId(rep.getConfiguracoesSenhaId());
		} else {
			ConfiguracoesSenha configuracoesSenha = new ConfiguracoesSenha();
			this.configuracoesSenhaRepository.save(configuracoesSenha);
			tarefa.setConfiguracoesSenhaId(configuracoesSenha);
			rep.setConfiguracoesSenhaId(configuracoesSenha);
			this.getRepService().salvar(rep);
		}
		tarefa.setRepId(rep);
		this.getTarefaRepository().save(tarefa);
	}

	/**
	 * Agenda uma tarefa para receber as Configurações dos Cartões
	 * 
	 * @param rep
	 */
	public void receberConfigCartoes(Rep rep) {
		Tarefa tarefa = new Tarefa();
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_CARTOES.ordinal());
		tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());

		if (rep.getConfiguracoesCartoesId() != null) {
			tarefa.setConfiguracoesCartoesId(rep.getConfiguracoesCartoesId());
		} else {
			ConfiguracoesCartoes configuracoesCartoes = new ConfiguracoesCartoes();
			this.configuracoesCartoesRepository.save(configuracoesCartoes);
			tarefa.setConfiguracoesCartoesId(configuracoesCartoes);
			rep.setConfiguracoesCartoesId(configuracoesCartoes);
			this.getRepService().salvar(rep);
		}
		tarefa.setRepId(rep);
		this.getTarefaRepository().save(tarefa);
	}

	/**
	 * Agenda uma tarefa para receber as Configurações de Rede
	 * 
	 * @param rep
	 */
	public void receberConfigRede(Rep rep) {
		Tarefa tarefa = new Tarefa();
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_REDE.ordinal());
		tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());

		if (rep.getConfiguracoesRedeId() != null) {
			tarefa.setConfiguracoesRedeId(rep.getConfiguracoesRedeId());
		} else {
			ConfiguracoesRede configuracoesRede = new ConfiguracoesRede();
			this.configuracoesRedeRepository.save(configuracoesRede);
			tarefa.setConfiguracoesRedeId(configuracoesRede);
			rep.setConfiguracoesRedeId(configuracoesRede);
			this.getRepService().salvar(rep);
		}
		tarefa.setRepId(rep);
		this.getTarefaRepository().save(tarefa);
	}

	/**
	 * Agenda uma tarefa para receber o Relógio atual do Rep
	 * 
	 * @param rep
	 */
	public void receberConfigRelogio(Rep rep) {
		Tarefa tarefa = new Tarefa();
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_RELOGIO.ordinal());
		tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());

		if (rep.getRelogioId() != null) {
			tarefa.setRelogioId(rep.getRelogioId());
		} else {
			Relogio relogio = new Relogio();
			this.relogioRepository.save(relogio);
			tarefa.setRelogioId(relogio);
			rep.setRelogioId(relogio);
			this.getRepService().salvar(rep);
		}
		tarefa.setRepId(rep);
		this.getTarefaRepository().save(tarefa);
	}

	/**
	 * Agenda uma tarefa para receber as Configurações de Horário de Verão
	 * 
	 * @param rep
	 */
	public void receberConfigHorarioVerao(Rep rep) {
		Tarefa tarefa = new Tarefa();
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_HORARIO_VERAO.ordinal());
		tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());

		if (rep.getHorarioVeraoId() != null) {
			tarefa.setHorarioVeraoId(rep.getHorarioVeraoId());
		} else {
			HorarioVerao horarioVerao = new HorarioVerao();
			this.horarioVeraoRepository.save(horarioVerao);
			tarefa.setHorarioVeraoId(horarioVerao);
			rep.setHorarioVeraoId(horarioVerao);
			this.getRepService().salvar(rep);
		}
		tarefa.setRepId(rep);
		this.getTarefaRepository().save(tarefa);
	}

	/**
	 * Agenda uma tarefa para receber as Configurações de Ajustes Biométricos
	 * 
	 * @param rep
	 */
	public void receberConfigAjustesBio(Rep rep) {
		Tarefa tarefa = new Tarefa();
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_BIO.ordinal());
		tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());

		if (rep.getAjustesBioId() != null) {
			tarefa.setAjustesBioId(rep.getAjustesBioId());
		} else {
			AjustesBio ajustesBio = new AjustesBio();
			this.ajusteBioRepository.save(ajustesBio);
			tarefa.setAjustesBioId(ajustesBio);
			rep.setAjustesBioId(ajustesBio);
			this.getRepService().salvar(rep);
		}
		tarefa.setRepId(rep);
		this.getTarefaRepository().save(tarefa);
	}

	/**
	 * Agenda uma tarefa para receber as Configurações do WebServer
	 * 
	 * @param rep
	 */
	public void receberConfigWebServer(Rep rep) {
		Tarefa tarefa = new Tarefa();
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_WEB_SERVER.ordinal());
		tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());

		if (rep.getConfiguracoesWebServerId() != null) {
			tarefa.setConfiguracoesWebServerId(rep.getConfiguracoesWebServerId());
		} else {
			ConfiguracoesWebServer configuracoesWebServer = new ConfiguracoesWebServer();
			this.configuracoesWebServerRepository.save(configuracoesWebServer);
			tarefa.setConfiguracoesWebServerId(configuracoesWebServer);
			rep.setConfiguracoesWebServerId(configuracoesWebServer);
			this.getRepService().salvar(rep);
		}
		tarefa.setRepId(rep);
		this.getTarefaRepository().save(tarefa);
	}

}
