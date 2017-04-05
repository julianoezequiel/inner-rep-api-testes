/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rep.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.api.rep.dto.comandos.HorarioVeraoCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "horario_verao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioVerao.findAll", query = "SELECT h FROM HorarioVerao h"),
    @NamedQuery(name = "HorarioVerao.findById", query = "SELECT h FROM HorarioVerao h WHERE h.id = :id"),
    @NamedQuery(name = "HorarioVerao.findByDataFim", query = "SELECT h FROM HorarioVerao h WHERE h.dataFim = :dataFim"),
    @NamedQuery(name = "HorarioVerao.findByDataInicio", query = "SELECT h FROM HorarioVerao h WHERE h.dataInicio = :dataInicio")})
public class HorarioVerao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @OneToMany(mappedBy = "horarioVeraoId")
    @JsonIgnore
    private Collection<Tarefa> tarefaCollection;
    @OneToMany(mappedBy = "horarioVeraoId")
    @JsonIgnore
    private Collection<Rep> repCollection;

    public HorarioVerao() {
    }

    public HorarioVerao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @XmlTransient
    public Collection<Tarefa> getTarefaCollection() {
        return tarefaCollection;
    }

    public void setTarefaCollection(Collection<Tarefa> tarefaCollection) {
        this.tarefaCollection = tarefaCollection;
    }

    @XmlTransient
    public Collection<Rep> getRepCollection() {
        return repCollection;
    }

    public void setRepCollection(Collection<Rep> repCollection) {
        this.repCollection = repCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioVerao)) {
            return false;
        }
        HorarioVerao other = (HorarioVerao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rep.entity.HorarioVerao[ id=" + id + " ]";
    }
    
	public HorarioVeraoCmd toHorarioVeraoCmd() {

		HorarioVeraoCmd cmd = new HorarioVeraoCmd();

		if (this.dataInicio != null && this.dataFim != null) {
			Calendar calendarInicio = Calendar.getInstance();

			calendarInicio.setTime(this.dataInicio);
			Calendar calendarFim = Calendar.getInstance();
			calendarFim.setTime(this.dataFim);

			cmd.setCfgHVerAnoF(calendarFim.get(Calendar.YEAR));
			cmd.setCfgHVerAnoI(calendarInicio.get(Calendar.YEAR));
			cmd.setCfgHVerDiaF(calendarFim.get(Calendar.DAY_OF_MONTH));
			cmd.setCfgHVerDiaI(calendarInicio.get(Calendar.DAY_OF_MONTH));
			cmd.setCfgHVerMesF(calendarFim.get(Calendar.MONTH) + 1);
			cmd.setCfgHVerMesI(calendarInicio.get(Calendar.MONTH) + 1);
		}
		return cmd;
	}
    
}
