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
    
    private int idcancion; 
    private String nombre; 
    private int duracion; 
    private boolean favorita; 

    public cancion(int idcancion, String nombre, int duracion, boolean favorita) {
        this.idcancion = idcancion;
        this.nombre = nombre;
        this.duracion = duracion;
        this.favorita = favorita;
    }

    public int getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(int idcancion) {
        this.idcancion = idcancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }
    
    public boolean añadirFavorito(favorita){
        return true; 
    }
    
}

    

