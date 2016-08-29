/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.juanca.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Juanca
 */
public class EstadoServicio implements Serializable {
    private static final long serialVersionUID = 1L;

    public String numeroOrden;

    private String estado;

    private String observaciones;
//@OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroOrden")
    private List<Cliente> clienteList;


    private String articulo;

    private double valor_Servicio;
    
    private Date fecha_Ingreso;

    
    
    
    public double getValor_Servicio() {
        return valor_Servicio;
    }

    public void setValor_Servicio(double valor_Servicio) {
        this.valor_Servicio = valor_Servicio;
    }

    public Date getFecha_Ingreso() {
        return fecha_Ingreso;
    }

    public void setFecha_Ingreso(Date fecha_Ingreso) {
        this.fecha_Ingreso = fecha_Ingreso;
    }
    
    
    
    

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }
    
    public EstadoServicio() {
    }

    public EstadoServicio(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public EstadoServicio(String numeroOrden, String estado) {
        this.numeroOrden = numeroOrden;
        this.estado = estado;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroOrden != null ? numeroOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoServicio)) {
            return false;
        }
        EstadoServicio other = (EstadoServicio) object;
        if ((this.numeroOrden == null && other.numeroOrden != null) || (this.numeroOrden != null && !this.numeroOrden.equals(other.numeroOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lavacor.entidades.EstadoServicio[ numeroOrden=" + numeroOrden + " ]";
    }
    
}
