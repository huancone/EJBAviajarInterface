/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author huanc
 */
@Embeddable
public class PaqueteHasProductoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idpaquete")
    private int idpaquete;
    @Basic(optional = false)
    @Column(name = "idProducto")
    private int idProducto;

    public PaqueteHasProductoPK() {
    }

    public PaqueteHasProductoPK(int idpaquete, int idProducto) {
        this.idpaquete = idpaquete;
        this.idProducto = idProducto;
    }

    public int getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(int idpaquete) {
        this.idpaquete = idpaquete;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpaquete;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaqueteHasProductoPK)) {
            return false;
        }
        PaqueteHasProductoPK other = (PaqueteHasProductoPK) object;
        if (this.idpaquete != other.idpaquete) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PaqueteHasProductoPK[ idpaquete=" + idpaquete + ", idProducto=" + idProducto + " ]";
    }
    
}
