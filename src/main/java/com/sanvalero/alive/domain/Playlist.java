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
public class Playlist {
    private int idplaylist; 
    private String nombre_playlist; 
    private String genero; 

    public Playlist(int idplaylist, String nombre_playlist, String genero) {
        this.idplaylist = idplaylist;
        this.nombre_playlist = nombre_playlist;
        this.genero = genero;
    }

    public int getIdplaylist() {
        return idplaylist;
    }

    public void setIdplaylist(int idplaylist) {
        this.idplaylist = idplaylist;
    }

    public String getNombre_playlist() {
        return nombre_playlist;
    }

    public void setNombre_playlist(String nombre_playlist) {
        this.nombre_playlist = nombre_playlist;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

  
}
