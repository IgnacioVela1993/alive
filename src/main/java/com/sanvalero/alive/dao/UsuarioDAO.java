/*
Para la clase de usuario, vamos a crear una DAO que sincronice con la base de datos para 
poder introducir los usuarios nuevos dados de alta en la plataforma. 
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
public class UsuarioDAO {
    //nacho: Vamos a crear dos conexiones con BBDD (una para canción y otra para usuario) 

//Nacho: He modificado el fichero: 
import com.sanvalero.alive.domain.usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CancionDAO {
//Nacho: Aquí tenemos que poner el usuario y contraseña de la BBDD
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL_CONEXION = "jdbc:mysql://localhost:3306/netflix";
    private final String USUARIO = "netflixuser";
    private final String CONTRASENA = "netflix1234";
    
    private Connection connection;
    
    public UsuarioDAO() {
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
     * Añadimos un usuario a la base de datos
     * @param usuario El usuario con la información que se quiere registrar
     * @throws SQLException 
     */
    public void addUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (id_usuario, Nombre, Apellido, nick, cuenta, Localidad) " +
                "VALUES (7372, Alejandro, Gómez, Alex135, Premium, Zaragoza)";
        
        PreparedStatement sentencia = connection.prepareStatement(sql);
        sentencia.setString(1, usuario.getid_usuario());
        sentencia.setString(2, usuario.getNombre());
        sentencia.setInt(3, usuario.getApellido());
        sentencia.setString(4, usuario.getnick());
        sentencia.setBoolean(5, usuario.iscuenta());
        sentencia.setString(6, usuario.getLocalidad());
        sentencia.executeUpdate();
    }
    
    /**
     * Obtiene la lista de usuarios de la base de datos
     * @return Usuarios
     */
    public ArrayList<usuario> getAllUsuarios() throws SQLException {        
        return new ArrayList<>();
    }
    
    /**
     * Elimina un usuario
     * @param id El id del usuario a eliminar
     */
    public void removeUsuario(int id) {
        
    }
    
    /**
     * Modifica la información de un usuario
     * @param usuario El usuario para modificar su información
     */
    public void modifyusuario(Usuario usuario) {
        
    }
}
    

