<%@page import="java.util.ArrayList"%>
<%@page import="com.sanvalero.netflix.domain.Movie"%>
<%@page import="com.sanvalero.netflix.dao.MovieDAO"%>
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
            MovieDAO movieDAO = new MovieDAO();
            ArrayList<Movie> movies = movieDAO.getAllMovies();
        %>
        <ul>
        <%
            for (Movie movie : movies) {
        %>
        <li><%= movie.getTitle() %> <a href="remove-movie?id=<%= movie.getId() %>">Eliminar</a></li>
        <%    
            }
        %>
        </ul>
        <!-- FIXME pelicula de ejemplo (eliminar cuando se desarrolle el listado) -->
        <li>Título de ejemplo <a href="remove-movie?id=45">Eliminar</a></li>
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
