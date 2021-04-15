/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanvalero.alive.domain;

/**
 *
 * @author nachovelagomez
 */
public class usuario {
    private int idusuario; 
    private String nombre; 
    private String apellido; 
    private String nick; 
    private boolean cuentaPremium; 
    private String localidad; 

    public usuario(int idusuario, String nombre, String apellido, String nick, boolean cuentaPremium, String localidad) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.cuentaPremium = cuentaPremium;
        this.localidad = localidad;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public boolean isCuentaPremium() {
        return cuentaPremium;
    }

    public void setCuentaPremium(boolean cuentaPremium) {
        this.cuentaPremium = cuentaPremium;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    public boolean convertirPremium(cuentaPremium){
        if (this.cuentaPremium > 0){
            return true; 
        }
        return false; 
    }

  

    
   
    
}
