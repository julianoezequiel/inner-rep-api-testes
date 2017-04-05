package com.api.rep.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	public final static Logger LOGGER = LoggerFactory.getLogger(Utils.class.getName());
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:MM");

	public static Date converterStringParaData(String data) {

		Integer dia = Integer.parseInt(data.substring(0, 2));
		Integer mes = Integer.parseInt(data.substring(2, 4));
		Integer ano = Integer.parseInt(data.substring(4, 8));

		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes - 1);
		c.set(Calendar.YEAR, ano);
		// LOGGER.info("Data : " + dateFormat.format(c.getTime()));
		return c.getTime();
	}

	public static Date converterStringParaHora(String data) {
		Integer hora = Integer.parseInt(data.substring(0, 2));
		Integer minutos = Integer.parseInt(data.substring(2, 4));

		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, hora);
		c.set(Calendar.MINUTE, minutos);
		// LOGGER.info("Hora : " + timeFormat.format(c.getTime()));
		return c.getTime();
	}

}
