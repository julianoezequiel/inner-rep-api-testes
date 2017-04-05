/**
 *******************************************************************************
 * Exemplo Comunicação HTTP
 *
 * Desenvolvido em Java 1.8
 *
 * Topdata Sistemas de Automação Ltda.
 * ******************************************************************************
 */
package com.api.rep.rest;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.contantes.CONSTANTES.TIPO_OPERACAO;
import com.api.rep.dao.AjusteBioRepository;
import com.api.rep.dao.ColetaDumpingRepository;
import com.api.rep.dao.ColetaRepository;
import com.api.rep.dao.ConfiguracoesCartoesRepository;
import com.api.rep.dao.ConfiguracoesRedeRepository;
import com.api.rep.dao.ConfiguracoesSenhaRepository;
import com.api.rep.dao.ConfiguracoesWebServerRepository;
import com.api.rep.dao.EmpregadoRepository;
import com.api.rep.dao.EmpregadorRepository;
import com.api.rep.dao.HorarioVeraoRepository;
import com.api.rep.dao.RelogioRepository;
import com.api.rep.dao.UsuarioBioRepository;
import com.api.rep.dto.comandos.AjustesBioCmd;
import com.api.rep.dto.comandos.ColetaCmd;
import com.api.rep.dto.comandos.ColetaDumpCmd;
import com.api.rep.dto.comandos.ConfiguracacoesWebServerCmd;
import com.api.rep.dto.comandos.ConfiguracaoSenhaCmd;
import com.api.rep.dto.comandos.ConfiguracoesCartoesCmd;
import com.api.rep.dto.comandos.ConfiguracoesRedeCmd;
import com.api.rep.dto.comandos.EmpregadoCmd;
import com.api.rep.dto.comandos.EmpregadorCmd;
import com.api.rep.dto.comandos.HorarioVeraoCmd;
import com.api.rep.dto.comandos.RelogioCmd;
import com.api.rep.dto.comandos.UsuarioBioCmd;
import com.api.rep.entity.AjustesBio;
import com.api.rep.entity.Coleta;
import com.api.rep.entity.ColetaDumping;
import com.api.rep.entity.ConfiguracoesCartoes;
import com.api.rep.entity.ConfiguracoesRede;
import com.api.rep.entity.ConfiguracoesSenha;
import com.api.rep.entity.ConfiguracoesWebServer;
import com.api.rep.entity.Empregado;
import com.api.rep.entity.Empregador;
import com.api.rep.entity.HorarioVerao;
import com.api.rep.entity.Relogio;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.entity.UsuarioBio;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.CmdHandler;
import com.api.rep.service.rep.RepService;
import com.api.rep.service.tarefa.TarefaService;

/**
 * Classe contem os método e URLs utilizadas para realizar o agendamento de
 * tarefas(Comandos) para o InnerRep realizar.
 * 
 * <p>
 * Estas URLs não possuem autenticação,pois são somentes métodos para testes<br>
 * Os métodos aqui listados são utilizados pelo Postman.
 * </p>
 * 
 * @author juliano.ezequiel
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "agendarTarefa")
public class AgendarTarefa extends ApiRestController {

	@Autowired
	private UsuarioBioRepository usuarioBioRepository;

	@Autowired
	private EmpregadoRepository empregadoRepository;

	@Autowired
	private EmpregadorRepository empregadorRepository;

	@Autowired
	private ColetaRepository coletaRepository;

	@Autowired
	private ConfiguracoesSenhaRepository configuracoesSenhaRepository;

	@Autowired
	private RelogioRepository relogioRepository;

	@Autowired
	private HorarioVeraoRepository horarioVeraoRepository;

	@Autowired
	private ConfiguracoesCartoesRepository configuracoesCartoesRepository;

	@Autowired
	private ConfiguracoesRedeRepository configuracoesRedeRepository;

	@Autowired
	private AjusteBioRepository ajusteBioRepository;

	@Autowired
	private ConfiguracoesWebServerRepository configuracoesWebServerRepository;

	@Autowired
	private ColetaDumpingRepository coletaDumpingRepository;

	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private RepService repService;

	/**
	 * Agenda uma tarefa de coleta
	 * 
	 * @param numSerie
	 * @param coletaCmd
	 * @return {@link Tarefa}
	 * @throws ServiceException
	 */
	@RequestMapping(value = "coleta", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa coletaCmd(@RequestBody ColetaCmd coletaCmd) throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), rep);

		Coleta coleta = coletaCmd.toColeta();
		coleta = this.coletaRepository.save(coleta);

		tarefa.setColetaId(coleta);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.COLETA.ordinal());

		return this.tarefaService.salvar(tarefa);
	}

	/**
	 * Agenda uma tarefa se coleta por Dump de memória
	 * 
	 * @param numSerie
	 * @param coletaDumpCmd
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "coletadump", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa coletaCmd(@RequestBody ColetaDumpCmd coletaDumpCmd) throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), rep);

		ColetaDumping coletaDumping = coletaDumpCmd.toColetaDumping();

		coletaDumping = this.coletaDumpingRepository.save(coletaDumping);

		tarefa.setColetaDumpingId(coletaDumping);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.COLETA_DUMPING.ordinal());

		return this.tarefaService.salvar(tarefa);
	}

	/**
	 * Agenda tarefas de envio/recebimento e exclusão de empregado
	 * 
	 * @param numSerie
	 * @param empregadoCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "empregado/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa empregado(@RequestBody EmpregadoCmd empregadoCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		Optional<Empregado> empregado = this.empregadoRepository.buscarPorPis(empregadoCmd.getfPis(), rep);
		Empregado empregado2 = empregadoCmd.toEmpregado();
		if (empregado.isPresent()) {
			empregado2.setId(empregado.get().getId());
		}
		empregado2 = this.empregadoRepository.save(empregado2);
		tarefa.setEmpregadoId(empregado2);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.EMPREGADO.ordinal());
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda tarefas de envio/recebimento e exclusão do empregador
	 * 
	 * @param numSerie
	 * @param empregadorCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "empregador/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa empregador(@RequestBody EmpregadorCmd empregadorCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);
		Empregador empregador = empregadorCmd.toEmpregador();
		empregador.setId(rep.getEmpregadorId() != null ? rep.getEmpregadorId().getId() : null);
		empregador = this.empregadorRepository.save(empregador);

		rep.setEmpregadorId(empregador);
		this.repService.salvar(rep);

		tarefa.setEmpregadorId(empregador);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.EMPREGADOR.ordinal());
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda tarefa de envio/recebimento e exclusão de biometria
	 * 
	 * @param numSerie
	 * @param empregadoCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "biometria/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa biometria(@RequestBody UsuarioBioCmd usuarioBioCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();

		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		UsuarioBio usuarioBio = usuarioBioCmd.toUsuarioBio();

		UsuarioBio usuarioBio2 = this.usuarioBioRepository.findOne(Example.of(usuarioBio));

		if (usuarioBio2 != null) {
			tarefa.setUsuarioBioId(usuarioBio2);
			tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.BIOMETRIA.ordinal());
			return this.tarefaService.salvar(tarefa);
		} else {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED,
					"Necessário realizar a recepção da biometria primeiro");
		}

	}

	/**
	 * Agenda a tarefa de recebimento da lista de usuários biometrico
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "listabiometria", method = RequestMethod.GET)
	public Tarefa listabiometria() throws ServiceException {
		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.LISTA_BIO.ordinal());
		// tipo somente lista bio
		tarefa.setTipoUrl(1);
		return this.tarefaService.salvar(tarefa);
	}

	/**
	 * Agenda o recebimento da lista biometria e de todas a digitais dos
	 * usuários biometrico.
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "listabiometriacomdigitais", method = RequestMethod.GET)
	public Tarefa listabiometriacomdigitais() throws ServiceException {
		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.LISTA_BIO.ordinal());
		// tipo lista bio com digitais
		tarefa.setTipoUrl(2);
		return this.tarefaService.salvar(tarefa);
	}

	/**
	 * Agenda o recebimento da lista de empregados
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "listaempregados", method = RequestMethod.GET)
	public Tarefa listaempregados() throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), rep);

		long exluidos = this.empregadoRepository.removeByrepId(rep);
		LOGGER.info("Lista de empregados excluida da base , total de excluidos " + exluidos);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.LISTA_EMPREGADO.ordinal());
		return this.tarefaService.salvar(tarefa);
	}

	/**
	 * Agenda a tarefa de envio/recebimento da lista de empregados via dump de
	 * memória
	 * 
	 * @param numSerie
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "listaempregadosdump/{operacao}", method = RequestMethod.POST)
	public Tarefa listaempreagadosdump(@PathVariable("operacao") String operacao) throws ServiceException {
		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.LISTA_EMPREGADO_DUMP.ordinal());
		return this.tarefaService.salvar(tarefa);
	}

	/**
	 * Agenda a tarefa de recebimento das informações do Rep
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Tarefa info() throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.INFO.ordinal());
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda a tarefa de atualização do firmware do Rep
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "atualizarfirmware", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Tarefa atualizarFw() throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.ENVIAR.name(), rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.ATUALIZACAO_FW.ordinal());
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda a tarefa de atualização de todos os Rep cadastrados no sistema
	 * 
	 * @throws ServiceException
	 */
	@RequestMapping(value = "atualizarfirmwaretodos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public void atualizarFwTodos() throws ServiceException {

		Collection<Rep> repList = this.repService.buscarTodosRep();
		repList.stream().forEach(r -> {
			Tarefa tarefa = null;
			try {
				tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.ENVIAR.name(), r);
				tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.ATUALIZACAO_FW.ordinal());
				tarefa.setRepId(r);
				this.tarefaService.salvar(tarefa);
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		});

	}

	/**
	 * Agenda a tarefa de atualização das páginas do WebServer do Rep
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "atualizarpaginas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Tarefa atualizarPaginas() throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.ENVIAR.name(), rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.ATUALIZACAO_PAGINAS.ordinal());
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda a tarefa de atualização das páginas do WebServer de todos os Rep
	 * cadastrados no sistema
	 * 
	 * @throws ServiceException
	 */
	@RequestMapping(value = "atualizarpaginastodos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public void atualizarPaginasTodos() throws ServiceException {
		Collection<Rep> repList = this.repService.buscarTodosRep();
		repList.stream().forEach(r -> {
			Tarefa tarefa = null;
			try {
				tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.ENVIAR.name(), r);
				tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.ATUALIZACAO_PAGINAS.ordinal());
				this.tarefaService.salvar(tarefa);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Agenda a tarefa de recebimento dos identificadores do Rep
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "identificadores", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Tarefa identificadores() throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.IDENTFICACAO.ordinal());
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda as tarefas de envio e recebimento das configurações de senha do
	 * Rep
	 * 
	 * @param numSerie
	 * @param configuracaoSenhaCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "configuracoes/senha/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa configSenha(@RequestBody ConfiguracaoSenhaCmd configuracaoSenhaCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		ConfiguracoesSenha configuracoesSenha = configuracaoSenhaCmd.toConfigurcacoesSenha();
		configuracoesSenha.setId(rep.getConfiguracoesSenhaId() != null ? rep.getConfiguracoesSenhaId().getId() : null);
		this.configuracoesSenhaRepository.save(configuracoesSenha);

		rep.setConfiguracoesSenhaId(configuracoesSenha);
		rep = this.repService.salvar(rep);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_SENHA.ordinal());
		tarefa.setConfiguracoesSenhaId(configuracoesSenha);
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda as tarefas de envio e recebimento do Relógio do Rep
	 * 
	 * @param numSerie
	 * @param relogioCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "relogio/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa relogio(@RequestBody RelogioCmd relogioCmd, @PathVariable String operacao) throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		Relogio relogio = relogioCmd.toRelogio();
		relogio.setId(rep.getRelogioId() != null ? rep.getRelogioId().getId() : null);
		this.relogioRepository.save(relogio);

		rep.setRelogioId(relogio);
		rep = this.repService.salvar(rep);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_RELOGIO.ordinal());
		tarefa.setRelogioId(relogio);

		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda as tarefas de envio e recebimento do Horário de verão do Rep
	 * 
	 * @param numSerie
	 * @param horarioVeraoCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "horarioverao/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa horarioverao(@RequestBody HorarioVeraoCmd horarioVeraoCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		HorarioVerao horarioVerao = horarioVeraoCmd.toHorarioVerao();
		horarioVerao.setId(rep.getHorarioVeraoId() != null ? rep.getHorarioVeraoId().getId() : null);
		this.horarioVeraoRepository.save(horarioVerao);

		rep.setHorarioVeraoId(horarioVerao);
		rep = this.repService.salvar(rep);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_HORARIO_VERAO.ordinal());
		tarefa.setHorarioVeraoId(horarioVerao);
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda as tarefas de envio e recebimento das configurações dos cartões do
	 * Rep
	 * 
	 * @param numSerie
	 * @param configuracoesCartoesCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "cartoes/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa cartoes(@RequestBody ConfiguracoesCartoesCmd configuracoesCartoesCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		ConfiguracoesCartoes configuracoesCartoes = configuracoesCartoesCmd.toConfiguracoesCartoes();
		configuracoesCartoes
				.setId(rep.getConfiguracoesCartoesId() != null ? rep.getConfiguracoesCartoesId().getId() : null);

		this.configuracoesCartoesRepository.save(configuracoesCartoes);

		rep.setConfiguracoesCartoesId(configuracoesCartoes);
		rep = this.repService.salvar(rep);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_CARTOES.ordinal());
		tarefa.setConfiguracoesCartoesId(configuracoesCartoes);
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda as tarefas de envio e recebimento das configurações de rede do Rep
	 * 
	 * @param numSerie
	 * @param configuracoesRedeCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "rede/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa rede(@RequestBody ConfiguracoesRedeCmd configuracoesRedeCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		ConfiguracoesRede configuracoesRede = configuracoesRedeCmd.toConfiguracoesRede();
		configuracoesRede.setId(rep.getConfiguracoesRedeId() != null ? rep.getConfiguracoesRedeId().getId() : null);

		this.configuracoesRedeRepository.save(configuracoesRede);

		rep.setConfiguracoesRedeId(configuracoesRede);
		rep = this.repService.salvar(rep);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_REDE.ordinal());
		tarefa.setConfiguracoesRedeId(configuracoesRede);
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda as tarefas de envio e recebimento das configurações dos ajustes
	 * biometricos
	 * 
	 * @param numSerie
	 * @param ajustesBioCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "ajustebio/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa ajusteBio(@RequestBody AjustesBioCmd ajustesBioCmd, @PathVariable String operacao)
			throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		AjustesBio ajustesBio = ajustesBioCmd.toAjustesBio();
		ajustesBio.setId(rep.getAjustesBioId() != null ? rep.getAjustesBioId().getId() : null);

		this.ajusteBioRepository.save(ajustesBio);

		rep.setAjustesBioId(ajustesBio);
		rep = this.repService.salvar(rep);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_BIO.ordinal());
		tarefa.setAjustesBioId(ajustesBio);
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda a tarefa de verificação das biometrias
	 * 
	 * @param numSerie
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "verificacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Tarefa verificacao() throws ServiceException {
		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(TIPO_OPERACAO.ENVIAR.name(), rep);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.VERIFICA_LISTA_BIO.ordinal());
		return this.tarefaService.salvar(tarefa);

	}

	/**
	 * Agenda as tarefas de envio e recebimento das configurações do web serve
	 * 
	 * @param numSerie
	 * @param configuracacoesWebServerCmd
	 * @param operacao
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "configwebserve/{operacao}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Tarefa configWebServer(@RequestBody ConfiguracacoesWebServerCmd configuracacoesWebServerCmd,
			@PathVariable String operacao) throws ServiceException {

		Rep rep = this.repService.getRep();
		Tarefa tarefa = this.tarefaService.tarefaTeste(operacao, rep);

		ConfiguracoesWebServer configuracoesWebServer = configuracacoesWebServerCmd.toConfigurcacoesWebServer();
		configuracoesWebServer
				.setId(rep.getConfiguracoesWebServerId() != null ? rep.getConfiguracoesWebServerId().getId() : null);

		this.configuracoesWebServerRepository.save(configuracoesWebServer);

		rep.setConfiguracoesWebServerId(configuracoesWebServer);
		rep = this.repService.salvar(rep);

		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_WEB_SERVER.ordinal());
		tarefa.setConfiguracoesWebServerId(configuracoesWebServer);
		return this.tarefaService.salvar(tarefa);

	}

	@RequestMapping(value = "excluirtarefas", method = RequestMethod.GET)
	public void excluirtarefas() {
		this.tarefaService.excluirTodas();
	}

}
