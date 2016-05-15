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
@Table(name = "tipoproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoproducto.findAll", query = "SELECT t FROM Tipoproducto t"),
    @NamedQuery(name = "Tipoproducto.findByIdTtipoProducto", query = "SELECT t FROM Tipoproducto t WHERE t.idTtipoProducto = :idTtipoProducto"),
    @NamedQuery(name = "Tipoproducto.findByNombreTipoProducto", query = "SELECT t FROM Tipoproducto t WHERE t.nombreTipoProducto = :nombreTipoProducto")})
public class Tipoproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTtipoProducto")
    private String idTtipoProducto;
    @Column(name = "nombreTipoProducto")
    private String nombreTipoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTtipoProducto")
    private List<Producto> productoList;

    public Tipoproducto() {
    }

    public Tipoproducto(String idTtipoProducto) {
        this.idTtipoProducto = idTtipoProducto;
    }

    public String getIdTtipoProducto() {
        return idTtipoProducto;
    }

    public void setIdTtipoProducto(String idTtipoProducto) {
        this.idTtipoProducto = idTtipoProducto;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTtipoProducto != null ? idTtipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoproducto)) {
            return false;
        }
        Tipoproducto other = (Tipoproducto) object;
        if ((this.idTtipoProducto == null && other.idTtipoProducto != null) || (this.idTtipoProducto != null && !this.idTtipoProducto.equals(other.idTtipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tipoproducto[ idTtipoProducto=" + idTtipoProducto + " ]";
    }
    
}
