
package com.sanvalero.alive.servlet;

/**
 *
 * @author nachovelagomez
 */
public class GetCancionServlet {
    
import com.sanvalero.alive.dao.CancionDAO;
import com.sanvalero.alive.domain.Cancion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que obtiene la lista completa de peliculas de la base de datos
 */
@WebServlet(name = "movies", urlPatterns = {"/movies"})
public class GetMoviesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<p>Listado de peliculas (con servlet)</p>");
        MovieDAO movieDAO = new MovieDAO();
        try {
            ArrayList<Movie> movies = movieDAO.getAllMovies();
            out.println("<ul>");
            for (Movie movie : movies) {
                out.println("<li>" + movie.getTitle() + " <a href='remove-movie?id=" + movie.getId() + "'>Eliminar</a></li>");
            }
            // FIXME pelicula de ejemplo (eliminar cuando se desarrolle el listado)
            out.println("<li>Pelicula de ejemplo</li> <a href='remove-movie?id=23'>Eliminar</a></li>");
            out.println("</ul>");

            // Muestra el mensaje (si lo hay)
            String message = request.getParameter("message");
            if (!message.equals("")) {
                out.println("<p style='color:green'>" + message + "</p>");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
    
}
