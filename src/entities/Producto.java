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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByDescripcionProducto", query = "SELECT p FROM Producto p WHERE p.descripcionProducto = :descripcionProducto")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "descripcionProducto")
    private String descripcionProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Proveedor> proveedorList;
    @JoinColumn(name = "idTtipoProducto", referencedColumnName = "idTtipoProducto")
    @ManyToOne(optional = false)
    private Tipoproducto idTtipoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<PaqueteHasProducto> paqueteHasProductoList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String descripcionProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    public Tipoproducto getIdTtipoProducto() {
        return idTtipoProducto;
    }

    public void setIdTtipoProducto(Tipoproducto idTtipoProducto) {
        this.idTtipoProducto = idTtipoProducto;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
