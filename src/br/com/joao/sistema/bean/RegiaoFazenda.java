/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.sistema.bean;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgil
 */
@Entity
@Table(name = "regiao_fazenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegiaoFazenda.findAll", query = "SELECT r FROM RegiaoFazenda r"),
    @NamedQuery(name = "RegiaoFazenda.findByIdRegiaoFazenda", query = "SELECT r FROM RegiaoFazenda r WHERE r.idRegiaoFazenda = :idRegiaoFazenda")})
public class RegiaoFazenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_regiao_fazenda")
    private Integer idRegiaoFazenda;
    @JoinColumn(name = "fazenda_id_fazenda", referencedColumnName = "id_fazenda")
    @ManyToOne(optional = false)
    private Fazenda fazendaIdFazenda;
    @JoinColumn(name = "plantio_id_plantio", referencedColumnName = "id_plantio")
    @ManyToOne(optional = false)
    private Plantio plantioIdPlantio;

    public RegiaoFazenda() {
    }

    public RegiaoFazenda(Integer idRegiaoFazenda) {
        this.idRegiaoFazenda = idRegiaoFazenda;
    }

    public Integer getIdRegiaoFazenda() {
        return idRegiaoFazenda;
    }

    public void setIdRegiaoFazenda(Integer idRegiaoFazenda) {
        this.idRegiaoFazenda = idRegiaoFazenda;
    }

    public Fazenda getFazendaIdFazenda() {
        return fazendaIdFazenda;
    }

    public void setFazendaIdFazenda(Fazenda fazendaIdFazenda) {
        this.fazendaIdFazenda = fazendaIdFazenda;
    }

    public Plantio getPlantioIdPlantio() {
        return plantioIdPlantio;
    }

    public void setPlantioIdPlantio(Plantio plantioIdPlantio) {
        this.plantioIdPlantio = plantioIdPlantio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegiaoFazenda != null ? idRegiaoFazenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegiaoFazenda)) {
            return false;
        }
        RegiaoFazenda other = (RegiaoFazenda) object;
        if ((this.idRegiaoFazenda == null && other.idRegiaoFazenda != null) || (this.idRegiaoFazenda != null && !this.idRegiaoFazenda.equals(other.idRegiaoFazenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "criamodelo.RegiaoFazenda[ idRegiaoFazenda=" + idRegiaoFazenda + " ]";
    }
    
}
