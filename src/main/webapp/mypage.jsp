<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Page</title>
    </head>
    <body>
        <h1>My page</h1>
        <%
            String message = "Hello";
            out.println("<p>Esto aparece como contenido de la web</p>");
        %>    
        <p><%=message%></p>
    </body>
</html>
