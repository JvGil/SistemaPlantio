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
@Table(name = "itens_insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensInsumo.findAll", query = "SELECT i FROM ItensInsumo i"),
    @NamedQuery(name = "ItensInsumo.findByIdItensInsumo", query = "SELECT i FROM ItensInsumo i WHERE i.idItensInsumo = :idItensInsumo")})
public class ItensInsumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_itens_insumo")
    private Integer idItensInsumo;
    @JoinColumn(name = "insumo_id_insumo", referencedColumnName = "id_insumo")
    @ManyToOne(optional = false)
    private Insumo insumoIdInsumo;
    @JoinColumn(name = "plantio_id_plantio", referencedColumnName = "id_plantio")
    @ManyToOne(optional = false)
    private Plantio plantioIdPlantio;

    public ItensInsumo() {
    }

    public ItensInsumo(Integer idItensInsumo) {
        this.idItensInsumo = idItensInsumo;
    }

    public Integer getIdItensInsumo() {
        return idItensInsumo;
    }

    public void setIdItensInsumo(Integer idItensInsumo) {
        this.idItensInsumo = idItensInsumo;
    }

    public Insumo getInsumoIdInsumo() {
        return insumoIdInsumo;
    }

    public void setInsumoIdInsumo(Insumo insumoIdInsumo) {
        this.insumoIdInsumo = insumoIdInsumo;
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
        hash += (idItensInsumo != null ? idItensInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensInsumo)) {
            return false;
        }
        ItensInsumo other = (ItensInsumo) object;
        if ((this.idItensInsumo == null && other.idItensInsumo != null) || (this.idItensInsumo != null && !this.idItensInsumo.equals(other.idItensInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "criamodelo.ItensInsumo[ idItensInsumo=" + idItensInsumo + " ]";
    }
    
}
