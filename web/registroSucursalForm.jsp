
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <h1>Sucursal registro</h1>
        <form action="registroSucursalController" method="post">
            <input type="text" name="rfc" placeholder="Ingrese rfc"/><br/>
            <input type="text" name="ubicacion" placeholder="Ingrese direccion de la sucursal"/><br/>
            <input type="text" name="gerente" placeholder="Ingrese nombre del gerente"/><br/>
            <input type="text" name="telefono" placeholder="Ingrese número telefonico"/><br/>
            <input type="submit" value="Aceptar"/>
        </form>
    </body>
</html>
