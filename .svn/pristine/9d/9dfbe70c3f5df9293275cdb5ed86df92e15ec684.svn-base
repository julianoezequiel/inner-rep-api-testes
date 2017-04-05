/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rep.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "nsr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nsr.findAll", query = "SELECT n FROM Nsr n"),
    @NamedQuery(name = "Nsr.findById", query = "SELECT n FROM Nsr n WHERE n.id = :id"),
    @NamedQuery(name = "Nsr.findByCei", query = "SELECT n FROM Nsr n WHERE n.cei = :cei"),
    @NamedQuery(name = "Nsr.findByCnpjCpf", query = "SELECT n FROM Nsr n WHERE n.cnpjCpf = :cnpjCpf"),
    @NamedQuery(name = "Nsr.findByCpfResponsavel", query = "SELECT n FROM Nsr n WHERE n.cpfResponsavel = :cpfResponsavel"),
    @NamedQuery(name = "Nsr.findByCrc", query = "SELECT n FROM Nsr n WHERE n.crc = :crc"),
    @NamedQuery(name = "Nsr.findByDadosEmpregado", query = "SELECT n FROM Nsr n WHERE n.dadosEmpregado = :dadosEmpregado"),
    @NamedQuery(name = "Nsr.findByDataAjustada", query = "SELECT n FROM Nsr n WHERE n.dataAjustada = :dataAjustada"),
    @NamedQuery(name = "Nsr.findByDataAntesAjuste", query = "SELECT n FROM Nsr n WHERE n.dataAntesAjuste = :dataAntesAjuste"),
    @NamedQuery(name = "Nsr.findByDataGravacao", query = "SELECT n FROM Nsr n WHERE n.dataGravacao = :dataGravacao"),
    @NamedQuery(name = "Nsr.findByDataMarcacao", query = "SELECT n FROM Nsr n WHERE n.dataMarcacao = :dataMarcacao"),
    @NamedQuery(name = "Nsr.findByHoraAjustada", query = "SELECT n FROM Nsr n WHERE n.horaAjustada = :horaAjustada"),
    @NamedQuery(name = "Nsr.findByHoraAntesAjuste", query = "SELECT n FROM Nsr n WHERE n.horaAntesAjuste = :horaAntesAjuste"),
    @NamedQuery(name = "Nsr.findByHorarioGravacao", query = "SELECT n FROM Nsr n WHERE n.horarioGravacao = :horarioGravacao"),
    @NamedQuery(name = "Nsr.findByHorarioMarcacao", query = "SELECT n FROM Nsr n WHERE n.horarioMarcacao = :horarioMarcacao"),
    @NamedQuery(name = "Nsr.findByLocal", query = "SELECT n FROM Nsr n WHERE n.local = :local"),
    @NamedQuery(name = "Nsr.findByNomeEmpregado", query = "SELECT n FROM Nsr n WHERE n.nomeEmpregado = :nomeEmpregado"),
    @NamedQuery(name = "Nsr.findByNumeroNsr", query = "SELECT n FROM Nsr n WHERE n.numeroNsr = :numeroNsr"),
    @NamedQuery(name = "Nsr.findByPis", query = "SELECT n FROM Nsr n WHERE n.pis = :pis"),
    @NamedQuery(name = "Nsr.findByRazaoSocial", query = "SELECT n FROM Nsr n WHERE n.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Nsr.findByRegistro", query = "SELECT n FROM Nsr n WHERE n.registro = :registro"),
    @NamedQuery(name = "Nsr.findByTipo", query = "SELECT n FROM Nsr n WHERE n.tipo = :tipo"),
    @NamedQuery(name = "Nsr.findByTipoEvento", query = "SELECT n FROM Nsr n WHERE n.tipoEvento = :tipoEvento"),
    @NamedQuery(name = "Nsr.findByTipoIndentificador", query = "SELECT n FROM Nsr n WHERE n.tipoIndentificador = :tipoIndentificador"),
    @NamedQuery(name = "Nsr.findByTipoOperacao", query = "SELECT n FROM Nsr n WHERE n.tipoOperacao = :tipoOperacao")})
public class Nsr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "cei")
    private String cei;
    @Size(max = 255)
    @Column(name = "cnpj_cpf")
    private String cnpjCpf;
    @Size(max = 255)
    @Column(name = "cpf_responsavel")
    private String cpfResponsavel;
    @Size(max = 255)
    @Column(name = "crc")
    private String crc;
    @Size(max = 255)
    @Column(name = "dados_empregado")
    private String dadosEmpregado;
    @Column(name = "data_ajustada")
    @Temporal(TemporalType.DATE)
    private Date dataAjustada;
    @Column(name = "data_antes_ajuste")
    @Temporal(TemporalType.DATE)
    private Date dataAntesAjuste;
    @Column(name = "data_gravacao")
    @Temporal(TemporalType.DATE)
    private Date dataGravacao;
    @Column(name = "data_marcacao")
    @Temporal(TemporalType.DATE)
    private Date dataMarcacao;
    @Column(name = "hora_ajustada")
    @Temporal(TemporalType.TIME)
    private Date horaAjustada;
    @Column(name = "hora_antes_ajuste")
    @Temporal(TemporalType.TIME)
    private Date horaAntesAjuste;
    @Column(name = "horario_gravacao")
    @Temporal(TemporalType.TIME)
    private Date horarioGravacao;
    @Column(name = "horario_marcacao")
    @Temporal(TemporalType.TIME)
    private Date horarioMarcacao;
    @Size(max = 255)
    @Column(name = "local")
    private String local;
    @Size(max = 255)
    @Column(name = "nome_empregado")
    private String nomeEmpregado;
    @Column(name = "numero_nsr")
    private Integer numeroNsr;
    @Size(max = 255)
    @Column(name = "pis")
    private String pis;
    @Size(max = 255)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Size(max = 600)
    @Column(name = "registro")
    private String registro;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 255)
    @Column(name = "tipo_evento")
    private String tipoEvento;
    @Column(name = "tipo_indentificador")
    private Integer tipoIndentificador;
    @Size(max = 255)
    @Column(name = "tipo_operacao")
    private String tipoOperacao;
    @JoinColumn(name = "rep_id", referencedColumnName = "id")
    @ManyToOne
    private Rep repId;

    public Nsr() {
    }

    public Nsr(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCei() {
        return cei;
    }

    public void setCei(String cei) {
        this.cei = cei;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getDadosEmpregado() {
        return dadosEmpregado;
    }

    public void setDadosEmpregado(String dadosEmpregado) {
        this.dadosEmpregado = dadosEmpregado;
    }

    public Date getDataAjustada() {
        return dataAjustada;
    }

    public void setDataAjustada(Date dataAjustada) {
        this.dataAjustada = dataAjustada;
    }

    public Date getDataAntesAjuste() {
        return dataAntesAjuste;
    }

    public void setDataAntesAjuste(Date dataAntesAjuste) {
        this.dataAntesAjuste = dataAntesAjuste;
    }

    public Date getDataGravacao() {
        return dataGravacao;
    }

    public void setDataGravacao(Date dataGravacao) {
        this.dataGravacao = dataGravacao;
    }

    public Date getDataMarcacao() {
        return dataMarcacao;
    }

    public void setDataMarcacao(Date dataMarcacao) {
        this.dataMarcacao = dataMarcacao;
    }

    public Date getHoraAjustada() {
        return horaAjustada;
    }

    public void setHoraAjustada(Date horaAjustada) {
        this.horaAjustada = horaAjustada;
    }

    public Date getHoraAntesAjuste() {
        return horaAntesAjuste;
    }

    public void setHoraAntesAjuste(Date horaAntesAjuste) {
        this.horaAntesAjuste = horaAntesAjuste;
    }

    public Date getHorarioGravacao() {
        return horarioGravacao;
    }

    public void setHorarioGravacao(Date horarioGravacao) {
        this.horarioGravacao = horarioGravacao;
    }

    public Date getHorarioMarcacao() {
        return horarioMarcacao;
    }

    public void setHorarioMarcacao(Date horarioMarcacao) {
        this.horarioMarcacao = horarioMarcacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNomeEmpregado() {
        return nomeEmpregado;
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        this.nomeEmpregado = nomeEmpregado;
    }

    public Integer getNumeroNsr() {
        return numeroNsr;
    }

    public void setNumeroNsr(Integer numeroNsr) {
        this.numeroNsr = numeroNsr;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getTipoIndentificador() {
        return tipoIndentificador;
    }

    public void setTipoIndentificador(Integer tipoIndentificador) {
        this.tipoIndentificador = tipoIndentificador;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Rep getRepId() {
        return repId;
    }

    public void setRepId(Rep repId) {
        this.repId = repId;
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
        if (!(object instanceof Nsr)) {
            return false;
        }
        Nsr other = (Nsr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rep.entity.Nsr[ id=" + id + " ]";
    }
    
}
