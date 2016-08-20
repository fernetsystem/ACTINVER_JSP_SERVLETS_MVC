
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        *{
            font-family: arial;
        }
    </style>
    <body>
        <h1>Cliente registro</h1>
        <form action="registroClienteController" method="post">
            <input type="text" name="nombre" placeholder="Ingresa tu nombre"/><br/>
            <input type="text" name="paterno" placeholder="Ingresa tu apellido paterno"/><br/>
            <input type="text" name="materno" placeholder="Ingresa tu apellido materno"/><br/>
            <select name="sexo">
                <option value="1">Mujer</option>
                <option value="0">Hombre</option>
            </select> <br/>
            <input type="text" name="estado" placeholder="Ingresa tu estado"/><br/>
            <input type="submit" value="Aceptar"/>
        </form>
    </body>
</html>
