package com.api.rep.service.comandos;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.dao.NsrRepository;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.dto.comunicacao.StatusColetaDTO;
import com.api.rep.entity.Nsr;
import com.api.rep.entity.Rep;
import com.api.rep.service.ApiService;
import com.api.rep.service.ColetaNsrHandler;
import com.api.rep.service.ServiceException;

@Service
public class ColetaService extends ApiService {

	public static HashMap<Integer, byte[]> dumpingColetaMap = new HashMap<>();

	@Autowired
	private NsrRepository nsrRepository;

	private Boolean cancelarColeta = false;

	@Value("${coleta.alteracoes}")
	Boolean coletarAlteracoes;

	private String rootPath = System.getProperty("catalina.home");
	private String path = rootPath + File.separator + "tmpFiles";

	/**
	 * Recebe os registro de NSR
	 * 
	 * @param registros
	 * @param rep
	 */
	public void coletaNsr(String registros, Rep rep) {

		this.setRep(rep);
		Nsr nsr = null;
		String[] registro = registros.split("\n");
		for (int i = 0; i < registro.length; i++) {

			String nsrRegistro = registro[i];

			Integer numNsr = ColetaNsrHandler.getNumNsr(nsrRegistro);
			if (numNsr != null) {
				try {
					nsr = this.nsrRepository.buscarPorNumNsr(numNsr, rep.getId());

					if (nsr == null) {
						if (coletarAlteracoes) {
							nsr = ColetaNsrHandler.NSR_HANDLER.get(nsrRegistro).convert(nsrRegistro, this);
							nsr.setRepId(rep);
							this.nsrRepository.saveAndFlush(nsr);
						}
						LOGGER.info("Novo NSR Coletado :" + registro[i].replace("\r", ""));
					} else {
						LOGGER.info("NSR Já coletado :" + registro[i].replace("\r", ""));
					}

				} catch (Exception e) {
					System.err.println(e);
				}
			}

		}
		if (nsr != null && nsr.getNumeroNsr() != null) {
			if (rep.getUltimoNsr() == null || nsr.getNumeroNsr() > rep.getUltimoNsr()) {
				rep.setUltimoNsr(nsr.getNumeroNsr());
				this.getRepService().salvar(rep);
			}
		}
	}

	/**
	 * Recebe os Registro
	 * 
	 * @param registros
	 * @param rep
	 * @return
	 * @throws ServiceException
	 */
	public RespostaSevidorDTO receber(MultipartFile dados, Rep rep) throws ServiceException {
		LOGGER.info("Inicio do recebimento do coleta");

		rep = this.getRepService().buscarPorNumeroSerie(rep);

		String registros = this.getServiceUtils().dadosCripto(rep, dados);
		// coleta os registros
		if (cancelarColeta) {
			cancelarColeta = false;
			throw new ServiceException(HttpStatus.RESET_CONTENT, "cancelado pelo usuário");
		} else {
			coletaNsr(registros, rep);
			LOGGER.info("Término do recebimento do coleta");
			return new RespostaSevidorDTO(HttpStatus.OK);
		}

	}

	/**
	 * Método não esta em uso
	 * 
	 * @param statusColetaDTO
	 * @param repAutenticado
	 * @return
	 * @throws ServiceException
	 */
	public RespostaSevidorDTO statusColeta(StatusColetaDTO statusColetaDTO, Rep repAutenticado)
			throws ServiceException {
		LOGGER.info("Status da coleta : " + statusColetaDTO.getRegistrosColeto() + " Rep : "
				+ repAutenticado.getNumeroSerie());
		if (cancelarColeta) {
			cancelarColeta = false;
			throw new ServiceException(HttpStatus.RESET_CONTENT, "cancelado pelo usuário");
		} else {
			return new RespostaSevidorDTO(HttpStatus.OK);
		}
	}

	/**
	 * Consulta na base de dados os NSR pelo Rep
	 * 
	 * @param rep
	 * @return
	 * @throws ServiceException
	 */
	public Collection<Nsr> buscarNsrPorRep(Rep rep) throws ServiceException {
		if (rep != null) {
			rep = this.getRepService().buscarPorNumeroSerie(rep.getNumeroSerie());
			return this.nsrRepository.buscarPorRep(rep);
		} else {
			throw new ServiceException(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	/**
	 * Exclui todos os NSR da base de dados.
	 * 
	 * @param repAutenticado
	 * @return
	 * @throws ServiceException
	 */
	public Long excluirTodos(Rep repAutenticado) throws ServiceException {
		return this.nsrRepository.removeByrepId(this.getRepService().buscarPorNumeroSerie(repAutenticado));
	}

	/**
	 * Calcula o total de NSR coletado de um Rep
	 * 
	 * @param repAutenticado
	 * @return
	 * @throws ServiceException
	 */
	public Long total(Rep repAutenticado) throws ServiceException {
		this.setRep(this.getRepService().buscarPorNumeroSerie(repAutenticado));
		Nsr nsr = new Nsr();
		nsr.setRepId(this.getRep());
		return this.nsrRepository.count(Example.of(nsr));
	}

	public Long total() throws ServiceException {
		return this.nsrRepository.count();
	}

	/**
	 * Cancela um acoleta iniciada
	 * 
	 * @param repAutenticado
	 * @return
	 */
	public Boolean cancelar() {
		cancelarColeta = true;
		return cancelarColeta;
	}

	/**
	 * Recebe o Dump da MRP do Rep
	 * 
	 * @param arquivoColeta
	 * @param repAutenticado
	 * @param nsu
	 * @throws ServiceException
	 */
	public void receberDumping(MultipartFile arquivoColeta, Rep repAutenticado, Integer nsu) throws ServiceException {
		try {
			repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
			if (ColetaService.dumpingColetaMap.containsKey(nsu)) {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				outputStream.write(ColetaService.dumpingColetaMap.get(nsu));
				outputStream.write(this.getDecriptoAES().decript(repAutenticado.getChaveAES(),
						IOUtils.toByteArray(arquivoColeta.getInputStream())));
				ColetaService.dumpingColetaMap.remove(nsu);
				ColetaService.dumpingColetaMap.put(nsu, outputStream.toByteArray());
			} else {
				ColetaService.dumpingColetaMap.put(nsu, this.getDecriptoAES().decript(repAutenticado.getChaveAES(),
						IOUtils.toByteArray(arquivoColeta.getInputStream())));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Salva o arquivo da MRP no Servidor
	 * 
	 * @param nsu
	 */
	public void salvarArquivoDumpEmDisco(Integer nsu) {

		if (ColetaService.dumpingColetaMap.containsKey(nsu)) {
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File file = new File(dir.getAbsolutePath() + File.separator + nsu);

			BufferedOutputStream stream = null;
			try {
				stream = new BufferedOutputStream(new FileOutputStream(file));
				stream.write(ColetaService.dumpingColetaMap.get(nsu));
				stream.close();
				LOGGER.info("Arquivo dump criado = " + file.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
