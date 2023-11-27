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
    </head>
    <body>
        <div>
            <h1>Menu de Acciones que puedes Hacer</h1>
            <form action="IndexSv" method="post">
                <button type="submit" name="boton" value="boton1">Agregar Turno</button>

                <br><br>
                <button type="submit" name="boton" value="3">Buscar Turnos</button>
            </form> 
        </div>

        <div>
            <form action="IndexSv" method="get">
                <label>Fecha de busqueda</label>
                <input type="date" name="fechaBusqueda">
                <button type="submit" name="boton" value="boton2">Listar todos los Turnos</button>
            </form>
        </div>

        <div>
            <h2>Lista de Turnos</h2>
            <%if (request.getAttribute("resultados") != null) { %>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Nombre del Ciudadano</th>
                        <th>Apelliod Del Ciudadano</th>
                        <th>DNI del Ciudadano</th>
                        <th>Aciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Turno turno : (List<Turno>) request.getAttribute("resultados")) {%>
                    <tr>
                        <td><%=turno.getId()%></td>
                        <td><%=turno.getFecha()%></td>
                        <td><%=turno.getDescripcion()%></td>
                        <td><%=turno.getEstado()%></td>
                        <td><%=turno.getCiudadano().getNombre()%></td>
                        <td><%=turno.getCiudadano().getApellido()%></td>
                        <td><%=turno.getCiudadano().getDni()%></td>
                        <td>
                            <form action="IndexSv" method="post">
                                <button type="submit" name="boton" value="botonModificar">Modificar estado</button>
                            </form>
                        </td>
                    </tr>
                    <%} %> 
                </tbody>
            </table>

            <%}%>
        </div>
    </body>
</html>
