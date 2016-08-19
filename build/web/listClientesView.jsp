<%@page import="Beans.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <h1>Lista de clientes</h1>
        <% ArrayList<Cliente> clientes = (ArrayList<Cliente>)request.getAttribute("clientes"); %>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Paterno</th>
                <th>Materno</th>
                <th>Sexo</th>
                <th>Estado</th>
            </tr>
            <% for(int x=0;x<clientes.size();x++){
                out.println("<tr>");
                    out.println("<td>" + clientes.get(x).getNombre() + "</td>");
                    out.println("<td>" + clientes.get(x).getPaterno() + "</td>");
                    out.println("<td>" + clientes.get(x).getMaterno() + "</td>");                  
                    if(clientes.get(x).isSexo())
                        out.println("<td>Mujer</td>");
                    else
                        out.println("<td>Hombre</td>");
                    out.println("<td>" + clientes.get(x).getEstado() + "</td>");
                out.println("</tr>");
            }
            %>
        </table>
        
    </body>
</html>
