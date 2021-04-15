/*
Nacho: Vamos a crear una clase DAO para canciones, lo que queremos es que pueda
introducir una nueva canción a la base de datos y eliminarla. Igualmente, podemos 
introducir una canción como favorito. 
 */
package com.sanvalero.alive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nachovelagomez
 */
public class CancionDAO {
    
//Nacho: Vamos a crear dos conexiones con BBDD (una para canción y otra para usuario) 

//Nacho: He modificado el fichero: 
import com.sanvalero.alive.domain.cancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CancionDAO {
//Nacho: Aquí tenemos que poner el usuario y contraseña de la BBDD. FALTA POR CAMBIAR. 
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL_CONEXION = "jdbc:mysql://localhost:3306/netflix";
    private final String USUARIO = "netflixuser";
    private final String CONTRASENA = "netflix1234";
    
    private Connection connection;
    
    public CancionDAO() {
        connect();
    }
    
    /**
     * Conecta con la base de datos
     */
    public void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    /**
     * Desconecta de la base de datos
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    /**
     * Añade una canción a la base de datos
     * @param cancion La canción con la información que se quiere registrar
     * @throws SQLException 
     */
    public void addCancion(Movie cancion) throws SQLException {
        
       // Ojo! En la base de datos tiene que ir el nombre el individual 
        String sql = "INSERT INTO cancion (id_cancion, id_Artista, Minutos, Num_reproduccion, Favorito)" +
                "VALUES (1347, 1283, 3, 4, si)";
        
        PreparedStatement sentencia = connection.prepareStatement(sql);
        sentencia.setString(1, cancion.getid_cancion());
        sentencia.setString(2, cancion.getid_Artista());
        sentencia.setInt(3, cancion.getMinutos());
        sentencia.setString(4, cancion.getNum_reproduccion());
        sentencia.setBoolean(5, cancion.isFavorito());
        sentencia.executeUpdate();
    }
    
    /**
     * Obtiene la lista de canciones de la base de datos
     * @return Una colección con las canciones 
     */
    public ArrayList<Cancion> getAllCanciones() throws SQLException {        
        return new ArrayList<>();
    }
    
    /**
     * Eliminar una cancion
     * @param id El id de la cancion a eliminar
     */
    public void removeCancion(int id) {
        
    }
    
    /**
     * Modifica la información de una canción
     * @param cancion La canción con la información a modificar
     */
    public void modifyCancion(Cancion cancion) {
        
    }
}
    
}
