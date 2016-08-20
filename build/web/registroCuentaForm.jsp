
<%@page import="Beans.Sucursal"%>
<%@page import="Beans.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro cuenta</h1>
        <% 
           ArrayList<Cliente> clientes = (ArrayList<Cliente>)request.getAttribute("listaClientes"); 
           ArrayList<Sucursal> sucursales = (ArrayList<Sucursal>)request.getAttribute("listaSucursales");
        %>         
        <form action="registroCuentaController" method="post">
            <select name="idCliente">
                <% for(int x=0;x<clientes.size();x++)                     
                    out.println("<option value='"+clientes.get(x).getIdCliente()+"'>"+clientes.get(x).getNombre()+" "+clientes.get(x).getPaterno()+" "+clientes.get(x).getMaterno() +"</option>");
                %>                
            </select>
            <select name="idSucursal">
                <% for(int x=0;x<sucursales.size();x++)
                    out.println("<option value='"+sucursales.get(x).getIdSucursal()+"'>"+sucursales.get(x).getRFC()+"</option>");
                %>
            </select>
            <input type="number" name="saldo" placeholder="Saldo"/>
            <input type="submit" value="Aceptar" />
        </form>
    </body>
</html>
