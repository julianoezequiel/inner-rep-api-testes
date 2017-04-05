/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rep.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "identificadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Identificadores.findAll", query = "SELECT i FROM Identificadores i"),
    @NamedQuery(name = "Identificadores.findById", query = "SELECT i FROM Identificadores i WHERE i.id = :id"),
    @NamedQuery(name = "Identificadores.findByChavePublica", query = "SELECT i FROM Identificadores i WHERE i.chavePublica = :chavePublica"),
    @NamedQuery(name = "Identificadores.findByIdApr", query = "SELECT i FROM Identificadores i WHERE i.idApr = :idApr"),
    @NamedQuery(name = "Identificadores.findByIdMrp", query = "SELECT i FROM Identificadores i WHERE i.idMrp = :idMrp"),
    @NamedQuery(name = "Identificadores.findByVersaoApl", query = "SELECT i FROM Identificadores i WHERE i.versaoApl = :versaoApl"),
    @NamedQuery(name = "Identificadores.findByVersaoBio", query = "SELECT i FROM Identificadores i WHERE i.versaoBio = :versaoBio"),
    @NamedQuery(name = "Identificadores.findByVersaoBoot", query = "SELECT i FROM Identificadores i WHERE i.versaoBoot = :versaoBoot"),
    @NamedQuery(name = "Identificadores.findByVersaoImp", query = "SELECT i FROM Identificadores i WHERE i.versaoImp = :versaoImp"),
    @NamedQuery(name = "Identificadores.findByVersaoMrp", query = "SELECT i FROM Identificadores i WHERE i.versaoMrp = :versaoMrp"),
    @NamedQuery(name = "Identificadores.findByVersaoProx", query = "SELECT i FROM Identificadores i WHERE i.versaoProx = :versaoProx"),
    @NamedQuery(name = "Identificadores.findByVersaoTamper", query = "SELECT i FROM Identificadores i WHERE i.versaoTamper = :versaoTamper")})
public class Identificadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "chave_publica")
    private String chavePublica;
    @Size(max = 255)
    @Column(name = "id_apr")
    private String idApr;
    @Size(max = 255)
    @Column(name = "id_mrp")
    private String idMrp;
    @Size(max = 255)
    @Column(name = "versao_apl")
    private String versaoApl;
    @Size(max = 255)
    @Column(name = "versao_bio")
    private String versaoBio;
    @Size(max = 255)
    @Column(name = "versao_boot")
    private String versaoBoot;
    @Size(max = 255)
    @Column(name = "versao_imp")
    private String versaoImp;
    @Size(max = 255)
    @Column(name = "versao_mrp")
    private String versaoMrp;
    @Size(max = 255)
    @Column(name = "versao_prox")
    private String versaoProx;
    @Size(max = 255)
    @Column(name = "versao_tamper")
    private String versaoTamper;
    @OneToMany(mappedBy = "indentificadoresId")
    @JsonIgnore
    private Collection<Rep> repCollection;

    public Identificadores() {
    }

    public Identificadores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChavePublica() {
        return chavePublica;
    }

    public void setChavePublica(String chavePublica) {
        this.chavePublica = chavePublica;
    }

    public String getIdApr() {
        return idApr;
    }

    public void setIdApr(String idApr) {
        this.idApr = idApr;
    }

    public String getIdMrp() {
        return idMrp;
    }

    public void setIdMrp(String idMrp) {
        this.idMrp = idMrp;
    }

    public String getVersaoApl() {
        return versaoApl;
    }

    public void setVersaoApl(String versaoApl) {
        this.versaoApl = versaoApl;
    }

    public String getVersaoBio() {
        return versaoBio;
    }

    public void setVersaoBio(String versaoBio) {
        this.versaoBio = versaoBio;
    }

    public String getVersaoBoot() {
        return versaoBoot;
    }

    public void setVersaoBoot(String versaoBoot) {
        this.versaoBoot = versaoBoot;
    }

    public String getVersaoImp() {
        return versaoImp;
    }

    public void setVersaoImp(String versaoImp) {
        this.versaoImp = versaoImp;
    }

    public String getVersaoMrp() {
        return versaoMrp;
    }

    public void setVersaoMrp(String versaoMrp) {
        this.versaoMrp = versaoMrp;
    }

    public String getVersaoProx() {
        return versaoProx;
    }

    public void setVersaoProx(String versaoProx) {
        this.versaoProx = versaoProx;
    }

    public String getVersaoTamper() {
        return versaoTamper;
    }

    public void setVersaoTamper(String versaoTamper) {
        this.versaoTamper = versaoTamper;
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
        if (!(object instanceof Identificadores)) {
            return false;
        }
        Identificadores other = (Identificadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rep.entity.Identificadores[ id=" + id + " ]";
    }
    
}
