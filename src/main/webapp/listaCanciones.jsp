<%@page import="com.sanvalero.alive.domain.Cancion"%>
<%@page import="com.sanvalero.alive.dao.CancionDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de peliculas</title>
    </head>
    <body>
        <h1>Lista de peliculas (con JSP)</h1>
        <%
            CancionDAO cancionDAO = new CancionDAO();
            ArrayList<Cancion> canciones = cancionDAO.getAllCanciones();
        %>
        <ul>
        <%
            for (Cancion cancion : canciones) {
        %>
        <li><%= cancion.getNombre() %> <a href="remove-cancion?id=<%= cancion.getIdcancion() %>">Eliminar</a></li>
        <%    
            }
        %>
        </ul>
        <!-- FIXME pelicula de ejemplo (eliminar cuando se desarrolle el listado) -->
        <li>Título de ejemplo <a href="remove-cancion?id=45">Eliminar</a></li>
        <%
            // Muestra el mensaje (si lo hay)
            String message = request.getParameter("message");
            if (message != null) {
        %>
            <p style='color:green'><%= message %></p>
        <%        
            }
        %>
    </body>
</html>
