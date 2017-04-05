package com.api.rep.service.comandos;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;

@Service
public class AtualizarFirmwareService extends ApiService {

	public static HashMap<String, Object> firmware = new HashMap<>();

	private static String PAGINAS = "paginas.RB1";
	private static String FIRMWARE = "firmware.IR1";

	private String rootPath = System.getProperty("catalina.home");
	private String path = rootPath + File.separator + "tmpFiles";

	public HashMap<String, Object> enviarFirmware(Integer nsu, Rep repAutenticado) throws ServiceException {

		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);

		List<Tarefa> tarefas = this.getTarefaRepository().buscarPorNsu(nsu);
		InputStreamResource isr = null;
		HashMap<String, Object> map = new HashMap<>();

		if (!tarefas.isEmpty()) {

			try {
				// carrega o arquivo de atualização
				File dir = new File(path);
				File f = new File(dir.getAbsolutePath() + File.separator + FIRMWARE);
				if (f.exists()) {

					Path path = Paths.get(f.getAbsolutePath());
					byte[] data = Files.readAllBytes(path);

					byte[] dataCripto =  this.getCriptoAES().cripto(repAutenticado.getChaveAES(), data);
					InputStream inputStream =  new ByteArrayInputStream(dataCripto);
					isr = new InputStreamResource(inputStream);

					map.put("fw", isr);
					map.put("tamanho", (long) dataCripto.length);
					System.out.println("SIZE FIRMWARE : " + dataCripto.length);
				} else {
					throw new ServiceException(HttpStatus.NO_CONTENT, "Arquivo não exitente");
				}

			} catch (IOException e) {
				e.printStackTrace();
				throw new ServiceException(HttpStatus.NO_CONTENT, "Arquivo não exitente");
			}
		}
		return map;
	}

	public HashMap<String, Object> enviarPaginas(Integer nsu, Rep repAutenticado) throws ServiceException {

		List<Tarefa> tarefas = this.getTarefaRepository().buscarPorNsu(nsu);
		InputStreamResource isr = null;
		HashMap<String, Object> map = new HashMap<>();

		if (!tarefas.isEmpty()) {

			try {
				InputStream inputStream;
				File dir = new File(path);
				File f = new File(dir.getAbsolutePath() + File.separator + PAGINAS);
				if (f.exists()) {
					inputStream = new FileInputStream(f);
					isr = new InputStreamResource(inputStream);
					map.put("paginas", isr);
					map.put("tamanho", (long) inputStream.available());
				} else {
					throw new ServiceException(HttpStatus.NO_CONTENT, "Arquivo não exitente");
				}

			} catch (IOException e) {
				e.printStackTrace();
				throw new ServiceException(HttpStatus.NO_CONTENT, "Arquivo não exitente");
			}
		}
		return map;
	}

	public String uploadArquivo(String name, MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String extenxao = file.getOriginalFilename().toString()
						.substring(file.getOriginalFilename().toString().indexOf("."));
				// Create the file on server
				File serverFile = null;
				if (extenxao.equalsIgnoreCase(".RB1")) {
					serverFile = new File(dir.getAbsolutePath() + File.separator + PAGINAS);
				} else if (extenxao.equalsIgnoreCase(".IR1")) {
					serverFile = new File(dir.getAbsolutePath() + File.separator + FIRMWARE);
				} else {
					return "Arquivo Inválido " + file.getOriginalFilename().toString();
				}

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				LOGGER.info("Local do arquivo = " + serverFile.getAbsolutePath());

				return "upload completo file=" + file.getOriginalFilename();
			} catch (Exception e) {
				return "upload falhou " + file.getOriginalFilename() + " => " + e.getMessage();
			}
		} else {
			return "upload falhou " + file.getOriginalFilename() + " because the file was empty.";
		}

	}

}
