<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My form</title>
    </head>
    <body>
        <h1>Ejemplo de formulario web</h1>
        <form method="post" action="add-cancion">
            Nombre Canción:
            <input type="text" name="nombre"/><br/>
            Duración:
            <input type="text" name="duracion"/><br/>
            ID Canción: 
            <input type="text" name="id"/><br/>
            ¿Es tu favorita? 
            <input type="text" name="favorita"/><br/>
            <input type="submit" value="Añadir"/>
        </form>
        
        <%
            String status = request.getParameter("status");
            if (status == null)
                status = "";
                
            if (status.equals("ok")) {
                out.println("<p style='color:green'>La pelicula se ha registrado con éxito</p>");
            } else if (status.equals("error")) {
                out.println("<p style='color:red'>No se ha podido registrar la pelicula</p>");
            }
        %>
    </body>
</html>
