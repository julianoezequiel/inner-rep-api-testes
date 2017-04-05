package com.api.rep.dto.comandos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.api.rep.entity.Relogio;

public class RelogioCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private Integer cfgRelDia;
	private Integer cfgRelMes;
	private Integer cfgRelAno;
	private Integer cfgRelHora;
	private Integer cfgRelMin;
	private Integer cfgRelSeg;

	public synchronized Integer getCfgRelDia() {
		return cfgRelDia;
	}

	public synchronized void setCfgRelDia(Integer cfgRelDia) {
		this.cfgRelDia = cfgRelDia;
	}

	public synchronized Integer getCfgRelMes() {
		return cfgRelMes;
	}

	public synchronized void setCfgRelMes(Integer cfgRelMes) {
		this.cfgRelMes = cfgRelMes;
	}

	public synchronized Integer getCfgRelAno() {
		return cfgRelAno;
	}

	public synchronized void setCfgRelAno(Integer cfgRelAno) {
		this.cfgRelAno = cfgRelAno;
	}

	public synchronized Integer getCfgRelHora() {
		return cfgRelHora;
	}

	public synchronized void setCfgRelHora(Integer cfgRelHora) {
		this.cfgRelHora = cfgRelHora;
	}

	public synchronized Integer getCfgRelMin() {
		return cfgRelMin;
	}

	public synchronized void setCfgRelMin(Integer cfgRelMin) {
		this.cfgRelMin = cfgRelMin;
	}

	public synchronized Integer getCfgRelSeg() {
		return cfgRelSeg;
	}

	public synchronized void setCfgRelSeg(Integer cfgRelSeg) {
		this.cfgRelSeg = cfgRelSeg;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	public Relogio toRelogio() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Relogio relogio = new Relogio();
		if (this.cfgRelDia != null && this.cfgRelMes != null && this.cfgRelAno != null && this.cfgRelHora != null
				&& this.cfgRelMin != null && this.cfgRelSeg != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, this.cfgRelDia);
			calendar.set(Calendar.MONTH, this.cfgRelMes - 1);
			calendar.set(Calendar.YEAR, this.cfgRelAno);
			calendar.set(Calendar.HOUR_OF_DAY, this.cfgRelHora);
			calendar.set(Calendar.MINUTE, this.cfgRelMin);
			calendar.set(Calendar.SECOND, this.cfgRelSeg);

			relogio.setData(calendar.getTime());
			System.out.println(df.format(calendar.getTime()));
		}
		return relogio;
	}
}
