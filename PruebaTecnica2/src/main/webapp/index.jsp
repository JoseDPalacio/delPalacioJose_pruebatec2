<%-- 
    Document   : index
    Created on : 27 nov 2023, 11:13:27
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="IndexSv" method="post">
            <button type="submit" name="boton" value="boton1">Agregar Turno</button>
        </form>
        
        <br>
        <form action="IndexSv" method="post">
            <div>
                <label>Seleccione una fecha</label>
                <input type="date" name="fecha">
            </div>
            <button type="submit">Listar Turnos</button>
        </form>
        
        <br>
        <form>
            <button type="submit">Filtrar Turnos</button>
        </form>
        
    </body>
</html>
