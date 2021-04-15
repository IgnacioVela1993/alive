/*
Nacho: Vamos a crear una clase DAO para canciones, lo que queremos es que pueda
introducir una nueva canción a la base de datos y eliminarla. Igualmente, podemos 
introducir una canción como favorito. 
 */
package com.sanvalero.alive.dao;
import com.sanvalero.alive.domain.Cancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nachovelagomez
 */
    
//Nacho: Vamos a crear dos conexiones con BBDD (una para canción y otra para usuario) 

//Nacho: He modificado el fichero: 


public class CancionDAO {
//Nacho: Aquí tenemos que poner el usuario y contraseña de la BBDD. FALTA POR CAMBIAR. 
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONEXION = "jdbc:oracle:thin:@//localhost:1521/xe";
    private final String USUARIO = "ALIVE";
    private final String CONTRASENA = "1234";
    
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
    public void addCancion(Cancion cancion) throws SQLException {
        
       // Ojo! En la base de datos tiene que ir el nombre el individual 
        String sql = "INSERT INTO cancion " +
                "VALUES (?, ?, ?, ?)";
        
        PreparedStatement sentencia = connection.prepareStatement(sql);
        
        sentencia.setString(1, cancion.getNombre());
        sentencia.setString(2, cancion.getDuracion());
        sentencia.setString(3, cancion.getIdcancion());
        sentencia.setString(4, cancion.getFavorita());
        sentencia.executeUpdate();
    }
    
    /**
     * Obtiene la lista de canciones de la base de datos
     * @return Una colección con las canciones 
     */
    public ArrayList<Cancion> getAllCanciones() throws SQLException { 
       String sql = "SELECT id_cancion, nombre, duracion, favorita FROM cancion";
       ArrayList<Cancion> listadoCanciones = new ArrayList<>();
       PreparedStatement sentencia = connection.prepareStatement(sql);
       ResultSet resultado = sentencia.executeQuery();
       while (resultado.next()){
           Cancion cancion = new Cancion();
           cancion.setIdcancion(resultado.getString(1));
           cancion.setNombre(resultado.getString(2));
           cancion.setDuracion(resultado.getString(3));
           cancion.setFavorita(resultado.getString(4));
           listadoCanciones.add(cancion);
       }
        return listadoCanciones;
    }
    
    /**
     * Eliminar una cancion
     * @param id El id de la cancion a eliminar
     */
    public void removeCancion(String id) throws SQLException {
        String sql = "DELETE FROM cancion WHERE id_cancion = ?";
        PreparedStatement sentencia = connection.prepareStatement(sql);
        sentencia.setString(1, id);
        sentencia.executeUpdate();
    }
    
    /**
     * Modifica la información de una canción
     * @param cancion La canción con la información a modificar
     */
    public void modifyCancion(Cancion cancion) {
        
    }
}
    

