<%@page import="Services.sucursalService"%>
<%@page import="Beans.Sucursal"%>
<%@page import="Beans.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de cuentas</h1>
        <% ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>)request.getAttribute("cuentas"); 
           sucursalService service = new sucursalService();           
        %>
        <table>
            <thead>
                <tr>
                    <th>Cuenta</th>
                    <th>Cliente</th>
                    <th>Sucursal</th>
                    <th>RFC</th>
                    <th>Direccion</th>
                    <th>Saldo</th>
                </tr>
            </thead>
            <tbody>
                <% for(int x = 0; x <cuentas.size();x++){ 
                    Sucursal sucursal = new Sucursal();
                    sucursal = service.searchById(cuentas.get(x).getIdSucursal());
                    out.println("<tr>");                        
                        out.println("<td>" + cuentas.get(x).getIdCuenta() + "</td>");
                        out.println("<td>" + cuentas.get(x).getIdCliente() + "</td>");
                        out.println("<td>" + cuentas.get(x).getIdSucursal() + "</td>");
                        out.println("<td>" + sucursal.getRFC() + "</td>");
                        out.println("<td>" + sucursal.getUbicacion() + "</td>");
                        out.println("<td>" + cuentas.get(x).getSaldo() + "</td>");
                    out.println("</tr>");
                } 
                %>                
            </tbody>
        </table>

    </body>
</html>
