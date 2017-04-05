package com.api.rep.dto.comandos;

import java.util.Calendar;

import com.api.rep.entity.HorarioVerao;

public class HorarioVeraoCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private Integer cfgHVerDiaI;
	private Integer cfgHVerMesI;
	private Integer cfgHVerAnoI;
	private Integer cfgHVerDiaF;
	private Integer cfgHVerMesF;
	private Integer cfgHVerAnoF;

	public synchronized Integer getCfgHVerDiaI() {
		return cfgHVerDiaI;
	}

	public synchronized void setCfgHVerDiaI(Integer cfgHVerDiaI) {
		this.cfgHVerDiaI = cfgHVerDiaI;
	}

	public synchronized Integer getCfgHVerMesI() {
		return cfgHVerMesI;
	}

	public synchronized void setCfgHVerMesI(Integer cfgHVerMesI) {
		this.cfgHVerMesI = cfgHVerMesI;
	}

	public synchronized Integer getCfgHVerAnoI() {
		return cfgHVerAnoI;
	}

	public synchronized void setCfgHVerAnoI(Integer cfgHVerAnoI) {
		this.cfgHVerAnoI = cfgHVerAnoI;
	}

	public synchronized Integer getCfgHVerDiaF() {
		return cfgHVerDiaF;
	}

	public synchronized void setCfgHVerDiaF(Integer cfgHVerDiaF) {
		this.cfgHVerDiaF = cfgHVerDiaF;
	}

	public synchronized Integer getCfgHVerMesF() {
		return cfgHVerMesF;
	}

	public synchronized void setCfgHVerMesF(Integer cfgHVerMesF) {
		this.cfgHVerMesF = cfgHVerMesF;
	}

	public synchronized Integer getCfgHVerAnoF() {
		return cfgHVerAnoF;
	}

	public synchronized void setCfgHVerAnoF(Integer cfgHVerAnoF) {
		this.cfgHVerAnoF = cfgHVerAnoF;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	public HorarioVerao toHorarioVerao() {

		HorarioVerao horarioVerao = new HorarioVerao();

		if (this.cfgHVerDiaI != null && this.cfgHVerMesI != null && this.cfgHVerAnoI != null && this.cfgHVerDiaF != null
				&& this.cfgHVerMesF != null && this.cfgHVerAnoF != null) {

			Calendar calendarInicio = Calendar.getInstance();

			calendarInicio.set(Calendar.DAY_OF_MONTH, this.cfgHVerDiaI);
			calendarInicio.set(Calendar.MONTH, this.cfgHVerMesI - 1);
			calendarInicio.set(Calendar.YEAR, this.cfgHVerAnoI);
			horarioVerao.setDataInicio(calendarInicio.getTime());

			Calendar calendarFim = Calendar.getInstance();

			calendarFim.set(Calendar.DAY_OF_MONTH, this.cfgHVerDiaF);
			calendarFim.set(Calendar.MONTH, this.cfgHVerMesF - 1);
			calendarFim.set(Calendar.YEAR, this.cfgHVerAnoF);
			horarioVerao.setDataFim(calendarFim.getTime());

		}

		return horarioVerao;
	}

}
