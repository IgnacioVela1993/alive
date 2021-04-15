package com.sanvalero.alive.servlet;

import com.sanvalero.alive.dao.MovieDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que elimina una película a la base de datos
 */
@WebServlet(name = "remove-movie", urlPatterns = {"/remove-movie"})
public class RemoveMovieServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int movieId = Integer.parseInt(request.getParameter("id"));
        MovieDAO movieDAO = new MovieDAO();
        movieDAO.removeMovie(movieId);
        
        response.sendRedirect("movies?message=Pelicula eliminada");
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
