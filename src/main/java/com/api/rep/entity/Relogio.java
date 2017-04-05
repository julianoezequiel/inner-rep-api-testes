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

import com.api.rep.dto.comandos.RelogioCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "relogio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relogio.findAll", query = "SELECT r FROM Relogio r"),
    @NamedQuery(name = "Relogio.findById", query = "SELECT r FROM Relogio r WHERE r.id = :id"),
    @NamedQuery(name = "Relogio.findByData", query = "SELECT r FROM Relogio r WHERE r.data = :data")})
public class Relogio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @OneToMany(mappedBy = "relogioId")
    @JsonIgnore
    private Collection<Tarefa> tarefaCollection;
    @OneToMany(mappedBy = "relogioId")
    @JsonIgnore
    private Collection<Rep> repCollection;

    public Relogio() {
    }

    public Relogio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof Relogio)) {
            return false;
        }
        Relogio other = (Relogio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rep.entity.Relogio[ id=" + id + " ]";
    }
    
	public RelogioCmd toRelogioCmd() {
		RelogioCmd cmd = new RelogioCmd();
		if (data != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(data);
			cmd.setCfgRelAno(calendar.get(Calendar.YEAR));
			cmd.setCfgRelDia(calendar.get(Calendar.DATE));
			cmd.setCfgRelHora(calendar.get(Calendar.HOUR_OF_DAY));
			cmd.setCfgRelMes(calendar.get(Calendar.MONTH) + 1);
			cmd.setCfgRelMin(calendar.get(Calendar.MINUTE));
			cmd.setCfgRelSeg(calendar.get(Calendar.SECOND));
		}
		return cmd;
	}
    
}
