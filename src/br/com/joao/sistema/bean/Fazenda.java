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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgil
 */
@Entity
@Table(name = "fazenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fazenda.findAll", query = "SELECT f FROM Fazenda f"),
    @NamedQuery(name = "Fazenda.findByIdFazenda", query = "SELECT f FROM Fazenda f WHERE f.idFazenda = :idFazenda"),
    @NamedQuery(name = "Fazenda.findByNome", query = "SELECT f FROM Fazenda f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fazenda.findByEstado", query = "SELECT f FROM Fazenda f WHERE f.estado = :estado"),
    @NamedQuery(name = "Fazenda.findByCidade", query = "SELECT f FROM Fazenda f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Fazenda.findByCep", query = "SELECT f FROM Fazenda f WHERE f.cep = :cep"),
    @NamedQuery(name = "Fazenda.findByBairro", query = "SELECT f FROM Fazenda f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Fazenda.findByLogradouro", query = "SELECT f FROM Fazenda f WHERE f.logradouro = :logradouro"),
    @NamedQuery(name = "Fazenda.findByNumero", query = "SELECT f FROM Fazenda f WHERE f.numero = :numero"),
    @NamedQuery(name = "Fazenda.findByComplemento", query = "SELECT f FROM Fazenda f WHERE f.complemento = :complemento"),
    @NamedQuery(name = "Fazenda.findByAreaTotal", query = "SELECT f FROM Fazenda f WHERE f.areaTotal = :areaTotal")})
public class Fazenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fazenda")
    private Integer idFazenda;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Column(name = "complemento")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "area_total")
    private double areaTotal;

    public Fazenda() {
    }

    public Fazenda(Integer idFazenda) {
        this.idFazenda = idFazenda;
    }

    public Fazenda(Integer idFazenda, String nome, String estado, String cidade, String cep, String bairro, String logradouro, int numero, double areaTotal) {
        this.idFazenda = idFazenda;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.areaTotal = areaTotal;
    }

    public Integer getIdFazenda() {
        return idFazenda;
    }

    public void setIdFazenda(Integer idFazenda) {
        this.idFazenda = idFazenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFazenda != null ? idFazenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fazenda)) {
            return false;
        }
        Fazenda other = (Fazenda) object;
        if ((this.idFazenda == null && other.idFazenda != null) || (this.idFazenda != null && !this.idFazenda.equals(other.idFazenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "criamodelo.Fazenda[ idFazenda=" + idFazenda + " ]";
    }
    
}
