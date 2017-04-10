package com.api.rep.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.entity.Rep;

@Component
public class ServiceUtils extends ApiService {

	public String dadosCripto(Rep rep, MultipartFile dados) throws ServiceException {

		InputStream data = null;
		String comando = null;
		try {
			rep = this.getRepService().buscarPorNumeroSerie(rep.getNumeroSerie());

			data = dados.getInputStream();
			byte[] dadosCripto = IOUtils.toByteArray(data);
			byte[] comandoDescripto = this.getDecriptoAES().decript(rep.getChaveAES(), dadosCripto);
			comando = new String(comandoDescripto, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServiceException(HttpStatus.UNAUTHORIZED, ("Erro ao converter dados"));
		}
		return comando;
	}
	

}
