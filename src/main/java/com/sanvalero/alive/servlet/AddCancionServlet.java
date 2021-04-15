package com.sanvalero.alive.servlet;

import com.sanvalero.alive.dao.CancionDAO;
import com.sanvalero.alive.domain.Cancion;
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
// add-cancion
@WebServlet(name = "add-cancion", urlPatterns = {"/add-cancion"})
public class AddCancionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String duracion = request.getParameter("duracion");
        String id = request.getParameter("id");
        String favorita = request.getParameter("favorita");
        
        Cancion cancion = new Cancion(nombre, duracion, id, favorita);
        
        
        CancionDAO cancionDAO = new CancionDAO();
        try {
            cancionDAO.addCancion(cancion);
            
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
