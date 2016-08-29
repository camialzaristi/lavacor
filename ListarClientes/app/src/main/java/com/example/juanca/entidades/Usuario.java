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
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;

    private String password;

    private String nombreCompleto;

    private TipoUsuario fkTipoUsuario;

    public Usuario() {
    }

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario(String login, String password, String nombreCompleto) {
        this.login = login;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public TipoUsuario getFkTipoUsuario() {
        return fkTipoUsuario;
    }

    public void setFkTipoUsuario(TipoUsuario fkTipoUsuario) {
        this.fkTipoUsuario = fkTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lavacor.entidades.Usuario[ login=" + login + " ]";
    }
    
}
