/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author huanc
 */
@Entity
@Table(name = "paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p"),
    @NamedQuery(name = "Paquete.findByIdpaquete", query = "SELECT p FROM Paquete p WHERE p.idpaquete = :idpaquete"),
    @NamedQuery(name = "Paquete.findByDescripcionPaquete", query = "SELECT p FROM Paquete p WHERE p.descripcionPaquete = :descripcionPaquete")})
public class Paquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaquete")
    private Integer idpaquete;
    @Basic(optional = false)
    @Column(name = "descripcionPaquete")
    private String descripcionPaquete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paqueteIdpaquete")
    private List<Solicitud> solicitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paquete")
    private List<PaqueteHasProducto> paqueteHasProductoList;

    public Paquete() {
    }

    public Paquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Paquete(Integer idpaquete, String descripcionPaquete) {
        this.idpaquete = idpaquete;
        this.descripcionPaquete = descripcionPaquete;
    }

    public Integer getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public void setDescripcionPaquete(String descripcionPaquete) {
        this.descripcionPaquete = descripcionPaquete;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @XmlTransient
    public List<PaqueteHasProducto> getPaqueteHasProductoList() {
        return paqueteHasProductoList;
    }

    public void setPaqueteHasProductoList(List<PaqueteHasProducto> paqueteHasProductoList) {
        this.paqueteHasProductoList = paqueteHasProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaquete != null ? idpaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.idpaquete == null && other.idpaquete != null) || (this.idpaquete != null && !this.idpaquete.equals(other.idpaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Paquete[ idpaquete=" + idpaquete + " ]";
    }
    
}
