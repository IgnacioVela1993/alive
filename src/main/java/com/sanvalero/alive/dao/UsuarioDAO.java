/*
Para la clase de Usuario, vamos a crear una DAO que sincronice con la base de datos para 
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
    //nacho: Vamos a crear dos conexiones con BBDD (una para canción y otra para Usuario) 

//Nacho: He modificado el fichero: 

//Nacho: Aquí tenemos que poner el Usuario y contraseña de la BBDD
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONEXION = "jdbc:oracle:thin:@//localhost:1521/xe";
    private final String USUARIO = "ALIVE";
    private final String CONTRASENA = "1234";
    
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
     * Añadimos un Usuario a la base de datos
     * @param usuario El Usuario con la información que se quiere registrar
     * @throws SQLException 
     */
    public void addUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (id_usuario, nom_usuario, ape_usuario, nick, cuenta, localidad) " +
                "VALUES ('?', ?, ?, ?, ?, ?)";
        
        PreparedStatement sentencia = connection.prepareStatement(sql);
        sentencia.setInt(1, usuario.getid_usuario());
        sentencia.setString(2, usuario.getnom_usuario());
        sentencia.setInt(3, usuario.getape_usuario());
        sentencia.setString(4, usuario.getnick());
        sentencia.setBoolean(5, usuario.iscuenta());
        sentencia.setString(6, usuario.getLocalidad());
        sentencia.executeUpdate();
    }
    
    /**
     * Obtiene la lista de usuarios de la base de datos
     * @return Usuarios
     */
    public ArrayList<com.sanvalero.alive.domain.Usuario> getAllUsuarios() throws SQLException {        
        return new ArrayList<>();
    }
    
    /**
     * Elimina un Usuario
     * @param id El id del Usuario a eliminar
     */
    public void removeUsuario(int id) {
        
    }
    
    /**
     * Modifica la información de un Usuario
     * @param usuario El Usuario para modificar su información
     */
    public void modifyusuario(Usuario usuario) {
        
    }

    private static class Usuario {

        public Usuario() {
        }

    }
}
    

