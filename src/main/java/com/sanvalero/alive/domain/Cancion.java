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
public class Cancion {
    
    private String idcancion; 
    private String nombre; 
    private String duracion; 
    private String favorita; 

    public Cancion(String idcancion, String nombre, String duracion, String favorita) {
        this.idcancion = idcancion;
        this.nombre = nombre;
        this.duracion = duracion;
        this.favorita = favorita;
    }

    public Cancion() {
       
    }

    public String getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(String idcancion) {
        this.idcancion = idcancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFavorita() {
        return favorita;
    }

    public void setFavorita(String favorita) {
        this.favorita = favorita;
    }

    
}

    

