<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My form</title>
    </head>
    <body>
        <h1>Ejemplo de formulario web</h1>
        <form method="post" action="add-movie">
            Título:
            <input type="text" name="title"/><br/>
            Director:
            <input type="text" name="director"/><br/>
            Duración:
            <input type="text" name="duration"/><br/>
            Categoría:
            <input type="text" name="category"/><br/>
            Vista:
            <input type="checkbox" name="viewed"/><br/>
            <input type="submit" value="Registrar"/>
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
