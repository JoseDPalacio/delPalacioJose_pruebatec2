<%-- 
    Document   : modificarTurno
    Created on : 28 nov 2023, 11:28:45
    Author     : Usuario
--%>

<%@page import="jose.pruebatecnica2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Turno</title>
        <link rel="stylesheet" type="text/css" href="resources/css/modificarTurno.css">
    </head>
    <body class="modificar-estado">
        <h2>Datos Recogidos de la Fila</h2>

        <% Turno turno = (Turno) request.getAttribute("turno");%>
        <p>ID: <%= turno.getId()%></p>
        <p>Fecha: <%=turno.getFecha()%></p>
        <p>Descripción: <%=turno.getDescripcion()%></p>
        <p>Nuevo estado: <%=turno.getEstado()%></p>
        <p>Nombre Ciudadano: <%=turno.getCiudadano().getNombre()%></p>
        <p>Apellido Ciudadano: <%=turno.getCiudadano().getApellido()%></p>
        <p>DNI Ciudadano: <%=turno.getCiudadano().getDni()%></p>
        <br><br>

        <h3>Confirmado que ha sido atendido</h3>
        <br>
        <!-- Formulario oculto para recoger los datos y modificarlos en -->
        <form action="EditarTurnoSv" method="post">
            <input type="hidden" name="idTurno" value="<%=turno.getId()%>">
            <input type="hidden" name="fechaTurno" value="<%=turno.getFecha()%>">
            <input type="hidden" name="descripcionTurno" value="<%=turno.getDescripcion()%>">
            <input type="hidden" name="estadoTurno" value="<%= turno.getEstado() %>">
            <input type="hidden" name="nombreCiudadano" value="<%=turno.getCiudadano().getNombre()%>">
            <input type="hidden" name="apellidoCiudadano" value="<%=turno.getCiudadano().getApellido()%>">
            <input type="hidden" name="dniCiudadano" value="<%=turno.getCiudadano().getDni()%>">
            <button type="submit">Volver a Home</button>
        </form>
    </body>
</html>
