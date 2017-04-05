package com.api.rep.contantes;

/**
 * Contantes e enumeradores do Sitema
 * 
 * @author juliano.ezequiel
 *
 */
public class CONSTANTES {

	public static final String CHAVE_COMUNICACAO_DEFAULT = "**COMUNICACAO**";
	public static final String AUTH_KEY = "InnerRepPlus";
	public static final String CPF_TESTE = "04752873982";

	public static final String URL_EMPREGADOR = "/restrict/empregador";
	public static final String URL_EMPREGADO = "/restrict/empregado";
	public static final String URL_LISTA_EMPREGADO = "/restrict/empregado/lista";
	public static final String URL_LISTA_EMPREGADO_DUMPING = "/restrict/empregado/lista";
	public static final String URL_COLETA = "/restrict/coleta";
	public static final String URL_COLETA_DUMPING = "/restrict/coleta/dumping";
	public static final String URL_BIOMETRIA = "/restrict/empregado/bio";
	public static final String URL_BIOMETRIA_AJUSTES = "/restrict/empregado/ajustes";
	public static final String URL_LISTA_BIOMETRIA = "/restrict/empregado/listabio";
	public static final String URL_LISTA_BIOMETRIA_COM_DIGITAIS = "/restrict/empregado/lista/digitais";
	public static final String URL_VERIFICAR_BIO = "/restrict/verificarbio";
	public static final String URL_CONFIG_SENHA = "/restrict/config/senha";
	public static final String URL_CONFIG_CARTOES = "/restrict/config/cartoes";
	public static final String URL_CONFIG_REDE = "/restrict/config/rede";
	public static final String URL_CONFIG_HORARIO_VERAO = "/restrict/config/horarioverao";
	public static final String URL_CONFIG_WEB_SERVER = "/restrict/config/webserver";
	public static final String URL_INFO = "/restrict/info";
	public static final String URL_RELOGIO = "/restrict/relogio";

	public static final String URL_IDENTFICACAO = "/restrict/identificacao";
	public static final String URL_ATUALIZACAO_FW = "/restrict/atualizarfw";
	public static final String URL_ATUALIZACAO_PAGINAS = "/restrict/atualizarpaginas";

	public static final String URL_AUTH = "/auth";
	public static final String URL_STATUS = "/restrict/status";
	public static final String URL_AUTH_SIGN = "/auth/sign";

	/**
	 * Tipos de Operações utilizadas pelo REP
	 * 
	 * @author juliano.ezequiel
	 *
	 */
	public enum TIPO_OPERACAO {
		NENHUMA, // 0
		ENVIAR, // 1
		RECEBER, // 2
		EXCLUIR;// 3

		public static TIPO_OPERACAO get(Integer tipo) {
			if (tipo != null) {
				for (TIPO_OPERACAO operacao : values()) {
					if (operacao.ordinal() == tipo) {
						return operacao;
					}
				}
			}
			return null;
		}

	}

	/**
	 * Tipos de NSR
	 * 
	 * @author juliano.ezequiel
	 *
	 */
	public enum TIPOS_NSR {
		TRAILER, // 0
		CABECALHO, // 1
		ALTERACAO_INCLUSAO_EMPRESA, // 2
		REGISTRO_PONTO, // 3
		AJUSTE_RELOGIO, // 4
		ALTERACAO_INCLUSAO_EMPREGADO, // 5
		EVENTOS_SENSIVEIS// 6
	}

	/**
	 * Tipos de Respostas do Rep
	 * 
	 * @author juliano.ezequiel
	 *
	 */
	public enum STATUS_COM_REP {
		HTTPC_RESULT_OK, // 0
		HTTPC_RESULT_FALHA, // 1
		HTTPC_RESULT_NAO_AUTORIZADO, // 2
		HTTPC_RESULT_FALHA_JSON, // 3
		HTTPC_RESULT_DADOS_INVALIDOS, // 4
		HTTPC_RESULT_TAMANHO_DADOS_EXCEDIDO, // 5
		HTTPC_RESULT_TAM_BUFFER_EXCEDIDO, // 6
		HTTPC_RESULT_COMANDO_INVALIDO, // 7
		HTTPC_RESULT_EMPRESA_NAO_CADASTRADA, // 8
		HTTPC_RESULT_BASE_CHEIA, // 9
		HTTPC_RESULT_MEMORIA_CHEIA, // 10
		HTTPC_RESULT_CADASTRO_SUCESSO, // 11
		HTTPC_RESULT_ALTERADO_SUCESSO, // 12
		HTTPC_RESULT_NAO_ALTERADO, // 13
		HTTPC_RESULT_OCUPADO, // 14
		HTTPC_RESULT_EMPREGADO_NAO_CAD, // 15
		HTTPC_RESULT_EMPREGADO_EXCLUIDO_SUCESSO, // 16
		HTTPC_RESULT_BIO_NAO_CADASTRADA, // 17
		HTTPC_RESULT_BIO_EXCLUIDA_SUCESSO, // 18
		HTTPC_RESULT_CARTOES_JA_CADASTRADOS,// 19
		HTTPC_RESULT_SEM_BIO;//20
		
		public static STATUS_COM_REP get(Integer tipo) {
			if (tipo != null) {
				for (STATUS_COM_REP operacao : values()) {
					if (operacao.ordinal() == tipo) {
						return operacao;
					}
				}
			}
			return null;
		}
	}

}
