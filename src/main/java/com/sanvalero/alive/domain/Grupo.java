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
public class Grupo {
    private int idgrupo; 
    private String nombre; 
    private String genero; 

    public Grupo(int idgrupo, String nombre, String genero) {
        this.idgrupo = idgrupo;
        this.nombre = nombre;
        this.genero = genero;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
}
