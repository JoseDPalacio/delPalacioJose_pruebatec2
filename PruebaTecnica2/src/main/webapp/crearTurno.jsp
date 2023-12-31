<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Crear Turno</title>
        <link rel="stylesheet" type="text/css" href="resources/css/crearTurno.css">
    </head>
    <body class="crear-turno">
        <form action="CrearTurnoSv" method="post" accept-charset="UTF-8">
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
