/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.sistema.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jgil
 */
@Entity
@Table(name = "plantio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantio.findAll", query = "SELECT p FROM Plantio p"),
    @NamedQuery(name = "Plantio.findByIdPlantio", query = "SELECT p FROM Plantio p WHERE p.idPlantio = :idPlantio"),
    @NamedQuery(name = "Plantio.findByDataInicio", query = "SELECT p FROM Plantio p WHERE p.dataInicio = :dataInicio"),
    @NamedQuery(name = "Plantio.findByDataColheita", query = "SELECT p FROM Plantio p WHERE p.dataColheita = :dataColheita")})
public class Plantio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plantio")
    private Integer idPlantio;
    @Basic(optional = false)
    @Column(name = "data_inicio")
    private String dataInicio;
    @Basic(optional = false)
    @Column(name = "data_colheita")
    private String dataColheita;
    
    public Plantio() {
    }

    public Plantio(Integer idPlantio) {
        this.idPlantio = idPlantio;
    }

    public Plantio(Integer idPlantio, String dataInicio, String dataColheita) {
        this.idPlantio = idPlantio;
        this.dataInicio = dataInicio;
        this.dataColheita = dataColheita;
    }

    public Integer getIdPlantio() {
        return idPlantio;
    }

    public void setIdPlantio(Integer idPlantio) {
        this.idPlantio = idPlantio;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(String dataColheita) {
        this.dataColheita = dataColheita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantio != null ? idPlantio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantio)) {
            return false;
        }
        Plantio other = (Plantio) object;
        if ((this.idPlantio == null && other.idPlantio != null) || (this.idPlantio != null && !this.idPlantio.equals(other.idPlantio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "criamodelo.Plantio[ idPlantio=" + idPlantio + " ]";
    }
    
}
