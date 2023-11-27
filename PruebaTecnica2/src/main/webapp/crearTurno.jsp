<%-- 
    Document   : crearTurno
    Created on : 27 nov 2023, 12:02:05
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Turno</title>
    </head>
    <body>
        <form action="CrearTurnoSv" method="post">
            <h2>Datos del Ciudadano</h2>
            <!-- Div para los datos del ciudadano -->
            <div>
                <label for="nombre">Nombre*:</label>
                <input type="text" id="nombreCiudadano" name="nombreCiudadano" required>
                <br>
                <label for="apellido">Apellido*:</label>
                <input type="text" id="apellidoCiudadano" name="apellidoCiudadano" required>
                <br>
                <label for="dni">DNI*:</label>
                <input type="text" id="dniCiudadano" name="dniCiudadano" required>
            </div>
            
            <h2>Datos del Turno</h2>
            <!-- Div para los datos del tramite -->
            <div>
                <label for="Fecha">Fecha*:</label>
                <input type="date" id="fechaTurno" name="fechaTurno" required>
                <br>
                <label for="descripcionTramite">Descripcion del tramite*:</label>
                <input type="text" id="descripcionTramite" name="descripcionTramite" required>
            </div>
            
            <br><br>
            <button type="submit">Crear Turno</button>
        </form>
    </body>
</html>
