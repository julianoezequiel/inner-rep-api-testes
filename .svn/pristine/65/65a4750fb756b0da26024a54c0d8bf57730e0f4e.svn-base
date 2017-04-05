package com.api.rep.service.comandos;

import org.springframework.stereotype.Component;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.entity.Rep;
import com.api.rep.service.ApiService;
import com.api.rep.service.TratarResposta;

@Component
public class CmdHandler {

	public enum TIPO_CMD {

		CMD_NENHUM() {// 0
			@Override
			public String getUrl(int tipo) {
				return null;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		EMPREGADOR() {// 1
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_EMPREGADOR;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		EMPREGADO() {// 2
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_EMPREGADO;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		LISTA_EMPREGADO() {// 3
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_LISTA_EMPREGADO;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		LISTA_EMPREGADO_DUMP() {// 4
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_LISTA_EMPREGADO_DUMPING;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		COLETA() {// 5
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_COLETA;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		COLETA_DUMPING() {// 5
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_COLETA_DUMPING;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		BIOMETRIA() {// 6
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_BIOMETRIA;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		LISTA_BIO() {// 7 pis dos funcionario bio
			@Override
			public String getUrl(int tipo) {
				if (tipo == 1) {
					return CONSTANTES.URL_LISTA_BIOMETRIA;
				} else if (tipo == 2) {
					return CONSTANTES.URL_LISTA_BIOMETRIA_COM_DIGITAIS;
				} else {
					return null;
				}
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		VERIFICA_LISTA_BIO() {// 8

			@Override
			public String getUrl(int tipo) {
				// TODO Auto-generated method stub
				return CONSTANTES.URL_VERIFICAR_BIO;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		CONFIG_BIO() {// 9

			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_BIOMETRIA_AJUSTES;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		CONFIG_SENHA() {// 10
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_CONFIG_SENHA;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		CONFIG_REDE() {// 11
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_CONFIG_REDE;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		CONFIG_CARTOES() {// 12
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_CONFIG_CARTOES;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		CONFIG_HORARIO_VERAO() {// 13
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_CONFIG_HORARIO_VERAO;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		CONFIG_RELOGIO() {// 14
			@Override
			public String getUrl(int tpo) {
				return CONSTANTES.URL_RELOGIO;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		CONFIG_WEB_SERVER() {// 15

			@Override
			public String getUrl(int tipo) {
				// TODO Auto-generated method stub
				return CONSTANTES.URL_CONFIG_WEB_SERVER;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		INFO() {// 16
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_INFO;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		IDENTFICACAO() {// 17
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_IDENTFICACAO;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		ATUALIZACAO_FW() {// 18
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_ATUALIZACAO_FW;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		},
		ATUALIZACAO_PAGINAS() {// 19
			@Override
			public String getUrl(int tipo) {
				return CONSTANTES.URL_ATUALIZACAO_PAGINAS;
			}

			@Override
			public RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
					ApiService apiService) {
				// TODO Auto-generated method stub
				return null;
			}

		};

		public static TIPO_CMD get(Integer tipo) {
			if (tipo != null) {
				for (TIPO_CMD operacaocao : values()) {
					if (operacaocao.ordinal() == tipo) {
						return operacaocao;
					}
				}
			}
			return null;
		}

		public abstract String getUrl(int tpo);

		public abstract RespostaSevidorDTO tratarResposta(TratarResposta respostaRep, Rep repAutenticado,
				ApiService apiService);
	}

}
