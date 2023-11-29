<%@page import="java.util.List"%>
<%@page import="jose.pruebatecnica2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Trunos</title>
        <link rel="stylesheet" type="text/css" href="resources/css/verTurno.css">
    </head>
    <body>
        <section id="listaTurnos">
            <h2>Lista de Turnos</h2>
            <% if (request.getAttribute("resultados") != null) { %>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Descripción</th>
                        <th>Estado</th>
                        <th>Nombre del Ciudadano</th>
                        <th>Apellido del Ciudadano</th>
                        <th>DNI del Ciudadano</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Turno turno : (List<Turno>) request.getAttribute("resultados")) {%>
                    <tr>
                        <td><%= turno.getId()%></td>
                        <td><%= turno.getFecha()%></td>
                        <td><%= turno.getDescripcion()%></td>
                        <td><%= turno.getEstado()%></td>
                        <td><%= turno.getCiudadano().getNombre()%></td>
                        <td><%= turno.getCiudadano().getApellido()%></td>
                        <td><%= turno.getCiudadano().getDni()%></td>
                        <td>
                            <!-- Formulario oculto para recoger los datos -->
                            <form action="VerTurnoSv" method="post">
                                <input type="hidden" name="idTurno" value="<%= turno.getId()%>">
                                <input type="hidden" name="fechaTurno" value="<%= turno.getFecha()%>">
                                <input type="hidden" name="descripcionTurno" value="<%= turno.getDescripcion()%>">
                                <input type="hidden" name="nombreCiudadano" value="<%= turno.getCiudadano().getNombre()%>">
                                <input type="hidden" name="apellidoCiudadano" value="<%= turno.getCiudadano().getApellido()%>">
                                <input type="hidden" name="dniCiudadano" value="<%= turno.getCiudadano().getDni()%>">
                                <button type="submit" name="boton" value="botonModificar">Modificar estado</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% }%>
        </section>
    </body>
</html>
