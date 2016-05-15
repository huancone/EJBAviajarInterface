/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author huanc
 */
@Entity
@Table(name = "paquete_has_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaqueteHasProducto.findAll", query = "SELECT p FROM PaqueteHasProducto p"),
    @NamedQuery(name = "PaqueteHasProducto.findByIdpaquete", query = "SELECT p FROM PaqueteHasProducto p WHERE p.paqueteHasProductoPK.idpaquete = :idpaquete"),
    @NamedQuery(name = "PaqueteHasProducto.findByIdProducto", query = "SELECT p FROM PaqueteHasProducto p WHERE p.paqueteHasProductoPK.idProducto = :idProducto"),
    @NamedQuery(name = "PaqueteHasProducto.findByFechaSalida", query = "SELECT p FROM PaqueteHasProducto p WHERE p.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "PaqueteHasProducto.findByFechaRegreso", query = "SELECT p FROM PaqueteHasProducto p WHERE p.fechaRegreso = :fechaRegreso"),
    @NamedQuery(name = "PaqueteHasProducto.findByCantidadPersonas", query = "SELECT p FROM PaqueteHasProducto p WHERE p.cantidadPersonas = :cantidadPersonas"),
    @NamedQuery(name = "PaqueteHasProducto.findByCantidadHabitaciones", query = "SELECT p FROM PaqueteHasProducto p WHERE p.cantidadHabitaciones = :cantidadHabitaciones"),
    @NamedQuery(name = "PaqueteHasProducto.findByOrigen", query = "SELECT p FROM PaqueteHasProducto p WHERE p.origen = :origen"),
    @NamedQuery(name = "PaqueteHasProducto.findByDestino", query = "SELECT p FROM PaqueteHasProducto p WHERE p.destino = :destino")})
public class PaqueteHasProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaqueteHasProductoPK paqueteHasProductoPK;
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Column(name = "fechaRegreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegreso;
    @Column(name = "cantidadPersonas")
    private Integer cantidadPersonas;
    @Column(name = "cantidadHabitaciones")
    private Integer cantidadHabitaciones;
    @Column(name = "origen")
    private String origen;
    @Column(name = "destino")
    private String destino;
    @JoinColumn(name = "idpaquete", referencedColumnName = "idpaquete", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paquete paquete;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public PaqueteHasProducto() {
    }

    public PaqueteHasProducto(PaqueteHasProductoPK paqueteHasProductoPK) {
        this.paqueteHasProductoPK = paqueteHasProductoPK;
    }

    public PaqueteHasProducto(int idpaquete, int idProducto) {
        this.paqueteHasProductoPK = new PaqueteHasProductoPK(idpaquete, idProducto);
    }

    public PaqueteHasProductoPK getPaqueteHasProductoPK() {
        return paqueteHasProductoPK;
    }

    public void setPaqueteHasProductoPK(PaqueteHasProductoPK paqueteHasProductoPK) {
        this.paqueteHasProductoPK = paqueteHasProductoPK;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paqueteHasProductoPK != null ? paqueteHasProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaqueteHasProducto)) {
            return false;
        }
        PaqueteHasProducto other = (PaqueteHasProducto) object;
        if ((this.paqueteHasProductoPK == null && other.paqueteHasProductoPK != null) || (this.paqueteHasProductoPK != null && !this.paqueteHasProductoPK.equals(other.paqueteHasProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PaqueteHasProducto[ paqueteHasProductoPK=" + paqueteHasProductoPK + " ]";
    }
    
}
