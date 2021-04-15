package com.sanvalero.alive.servlet;

import com.sanvalero.alive.dao.MovieDAO;
import com.sanvalero.alive.domain.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que añade una película a la base de datos
 */
@WebServlet(name = "add-movie", urlPatterns = {"/add-movie"})
public class AddMovieServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String category = request.getParameter("category");
        boolean viewed = request.getParameter("viewed").equals("on");
        
        Movie movie = new Movie(title, director, duration, category, viewed);
        MovieDAO movieDAO = new MovieDAO();
        try {
            movieDAO.addMovie(movie);
            
            PrintWriter out = response.getWriter();
            response.sendRedirect("myform.jsp?status=ok");
        } catch (SQLException sqle) {
            response.sendRedirect("myform.jsp?status=error");
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
