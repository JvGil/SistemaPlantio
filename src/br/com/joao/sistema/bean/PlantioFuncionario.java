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
@Table(name = "plantio_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlantioFuncionario.findAll", query = "SELECT p FROM PlantioFuncionario p"),
    @NamedQuery(name = "PlantioFuncionario.findByIdPlantioFuncionario", query = "SELECT p FROM PlantioFuncionario p WHERE p.idPlantioFuncionario = :idPlantioFuncionario")})
public class PlantioFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plantio_funcionario")
    private Integer idPlantioFuncionario;
    @JoinColumn(name = "funcionario_codigo", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioCodigo;
    @JoinColumn(name = "plantio_id_plantio", referencedColumnName = "id_plantio")
    @ManyToOne(optional = false)
    private Plantio plantioIdPlantio;

    public PlantioFuncionario() {
    }

    public PlantioFuncionario(Integer idPlantioFuncionario) {
        this.idPlantioFuncionario = idPlantioFuncionario;
    }

    public Integer getIdPlantioFuncionario() {
        return idPlantioFuncionario;
    }

    public void setIdPlantioFuncionario(Integer idPlantioFuncionario) {
        this.idPlantioFuncionario = idPlantioFuncionario;
    }

    public Funcionario getFuncionarioCodigo() {
        return funcionarioCodigo;
    }

    public void setFuncionarioCodigo(Funcionario funcionarioCodigo) {
        this.funcionarioCodigo = funcionarioCodigo;
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
        hash += (idPlantioFuncionario != null ? idPlantioFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantioFuncionario)) {
            return false;
        }
        PlantioFuncionario other = (PlantioFuncionario) object;
        if ((this.idPlantioFuncionario == null && other.idPlantioFuncionario != null) || (this.idPlantioFuncionario != null && !this.idPlantioFuncionario.equals(other.idPlantioFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "criamodelo.PlantioFuncionario[ idPlantioFuncionario=" + idPlantioFuncionario + " ]";
    }
    
}
