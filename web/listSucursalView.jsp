
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Sucursal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <h1>Sucursales</h1>
        <<form action="" method="posr">
            <input type="text" name="idSucursal" placeholder="Buscar por id sucursal"/>
            <input type="submit" value="Aceptar" />
        </form>
        <br/>
        <% ArrayList<Sucursal> sucursales = (ArrayList<Sucursal>)request.getAttribute("sucursales");  %>
        <table>
            <tr>
                <th>RFC</th>
                <th>Direccion</th>
                <th>Gerente</th>
                <th>Telefono</th>
            </tr>
            <% for(int x=0;x<sucursales.size();x++){ 
                out.println("<tr>");
                    out.println("<td>" + sucursales.get(x).getRFC() + "</td>");
                    out.println("<td>" + sucursales.get(x).getUbicacion() + "</td>");
                    out.println("<td>" + sucursales.get(x).getNombreDelGerente() + "</td>");
                    out.println("<td>" + sucursales.get(x).getTelefono() + "</td>");
                out.println("</tr>");
            }    
            %>
        </table>        
    </body>
</html>
