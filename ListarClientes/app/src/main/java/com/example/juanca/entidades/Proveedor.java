/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.juanca.entidades;

import java.io.Serializable;


/**
 *
 * @author Juanca
 */
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nitProveedor;

    private String razonSocial;

    private String direccion;

    private String telefono;

    public Proveedor() {
    }

    public Proveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Proveedor(String nitProveedor, String razonSocial, String telefono) {
        this.nitProveedor = nitProveedor;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nitProveedor != null ? nitProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.nitProveedor == null && other.nitProveedor != null) || (this.nitProveedor != null && !this.nitProveedor.equals(other.nitProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lavacor.entidades.Proveedor[ nitProveedor=" + nitProveedor + " ]";
    }
    
}
