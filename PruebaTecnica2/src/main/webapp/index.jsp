<%-- 
    Document   : index
    Created on : 27 nov 2023, 11:13:27
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="jose.pruebatecnica2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="resources/css/styles.css">
    </head>
    <body class="datos-turno">
        <section id="agregarTurno">
            <h1>Menú de Acciones que Puedes Hacer</h1>
            <form action="IndexSv" method="post">
                <button type="submit" name="boton" value="boton1">Agregar Turno</button>
            </form>
        </section>

        <section id="buscarTurnos">
            <form action="IndexSv" method="get">
                <div>
                    <label>Fecha de Búsqueda</label>
                    <input type="date" name="fechaBusqueda">
                    <button type="submit" name="boton" value="botonFecha">Listar todos los Turnos por fecha concreta</button>
                </div>

                <div>
                    <label>Fecha de Búsqueda</label>
                    <input type="date" name="fechaBusqueda2">
                    <label>Estado del Turno</label>
                    <select id="estado" name="estadoTurno">
                        <option value="En espera">En espera</option>
                        <option value="Ya atendido">Ya atendido</option>
                    </select>
                    <button type="submit" name="boton" value="botonFechaEstado">Listar todos los Turnos por fecha concreta y estado</button>
                </div>
            </form>
        </section>

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
                            <form action="IndexSv" method="post">
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

