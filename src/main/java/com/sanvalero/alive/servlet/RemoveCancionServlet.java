package com.sanvalero.alive.servlet;

import com.sanvalero.alive.dao.CancionDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que elimina una película a la base de datos
 */
@WebServlet(name = "remove-cancion", urlPatterns = {"/remove-cancion"})
public class RemoveCancionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String cancionID = request.getParameter("id");
        CancionDAO cancionDAO = new CancionDAO();
        try {
            cancionDAO.removeCancion(cancionID);
        } catch (SQLException ex) {
            Logger.getLogger(RemoveCancionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("movies.jsp?message=Pelicula eliminada");
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
