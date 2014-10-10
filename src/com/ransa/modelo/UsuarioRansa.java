/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ransa.modelo;

/**
 *
 * @author jol
 */
public class UsuarioRansa {
    
    private int IdUsuario;
    private String TipoUsuario;
    private String CodUsuario;
    private String ApellidosUsuario;
    private String NombresUsuario;
    private String ContraSenia;
    private int IdCliente;
    private String CorreoUsuario;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public String getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(String CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public String getApellidosUsuario() {
        return ApellidosUsuario;
    }

    public void setApellidosUsuario(String ApellidosUsuario) {
        this.ApellidosUsuario = ApellidosUsuario;
    }

    public String getNombresUsuario() {
        return NombresUsuario;
    }

    public void setNombresUsuario(String NombresUsuario) {
        this.NombresUsuario = NombresUsuario;
    }

    public String getContraSenia() {
        return ContraSenia;
    }

    public void setContraSenia(String ContraSenia) {
        this.ContraSenia = ContraSenia;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String CorreoUsuario) {
        this.CorreoUsuario = CorreoUsuario;
    }
}
