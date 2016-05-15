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
@Table(name = "tiposolicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposolicitud.findAll", query = "SELECT t FROM Tiposolicitud t"),
    @NamedQuery(name = "Tiposolicitud.findByIdTipoSolicitud", query = "SELECT t FROM Tiposolicitud t WHERE t.idTipoSolicitud = :idTipoSolicitud"),
    @NamedQuery(name = "Tiposolicitud.findByDescripcionTipoSolicitud", query = "SELECT t FROM Tiposolicitud t WHERE t.descripcionTipoSolicitud = :descripcionTipoSolicitud")})
public class Tiposolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTipoSolicitud")
    private String idTipoSolicitud;
    @Basic(optional = false)
    @Column(name = "descripcionTipoSolicitud")
    private String descripcionTipoSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoSolicitud")
    private List<Solicitud> solicitudList;

    public Tiposolicitud() {
    }

    public Tiposolicitud(String idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public Tiposolicitud(String idTipoSolicitud, String descripcionTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
        this.descripcionTipoSolicitud = descripcionTipoSolicitud;
    }

    public String getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(String idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getDescripcionTipoSolicitud() {
        return descripcionTipoSolicitud;
    }

    public void setDescripcionTipoSolicitud(String descripcionTipoSolicitud) {
        this.descripcionTipoSolicitud = descripcionTipoSolicitud;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSolicitud != null ? idTipoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposolicitud)) {
            return false;
        }
        Tiposolicitud other = (Tiposolicitud) object;
        if ((this.idTipoSolicitud == null && other.idTipoSolicitud != null) || (this.idTipoSolicitud != null && !this.idTipoSolicitud.equals(other.idTipoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tiposolicitud[ idTipoSolicitud=" + idTipoSolicitud + " ]";
    }
    
}
