
<%@page import="Beans.Sucursal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <h1>Sucursal</h1>
        <% Sucursal s = (Sucursal)request.getAttribute("sucursal"); %>
        RFC: <%=s.getRFC() %> <br/>
        Direccion: <%=s.getUbicacion() %> <br/>
        Gerente: <%=s.getNombreDelGerente() %> <br/>
        Telefono: <%=s.getTelefono() %> <br/>
    </body>
</html>
