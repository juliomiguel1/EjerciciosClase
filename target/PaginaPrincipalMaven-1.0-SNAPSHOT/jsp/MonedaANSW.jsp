<%-- 
    Document   : MonedaANSW
    Created on : 17-sep-2015, 22:02:57
    Author     : juliomiguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet href="EstiloTabla.css" type="text/css">
        <title>Answer Page</title>
    </head>
    <body>
        <h1>Este es el cambio de moneda</h1>
        
        <%
            
            out.println("<table>");

            Double cambio = Double.parseDouble(request.getParameter("euro"));
            Double conveuro;
            Double convepese;
            
              conveuro = cambio * 166.386;
              convepese = cambio / 166.386;
            
            
            out.println(cambio + "  euros son " + conveuro + " pesetas" + "</br></br>");
            out.println(convepese + " euros son " +cambio +" pesetas ");
           
        %>
    </body>
</html>
