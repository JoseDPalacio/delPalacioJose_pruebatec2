<%@page import="java.util.List"%>
<%@page import="jose.pruebatecnica2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="resources/css/verTurno.css">
    </head>
    <body>
        <section id="agregarTurno">
            <h1>Menú de Acciones que Puedes Hacer</h1>
            <form action="IndexSv" method="post">
                <button type="submit" name="boton" value="boton1">Agregar Turno</button>
            </form>
        </section>

        <section id="buscarTurnos">
            <form action="IndexSv" method="get">
                <div>
                    <label>Fecha de Búsqueda*</label>
                    <input type="date" name="fechaBusqueda1">
                    <button type="submit" name="boton" value="botonFecha">Listar todos los Turnos por fecha concreta</button>
                </div>

                <div>
                    <label>Fecha de Búsqueda*</label>
                    <input type="date" name="fechaBusqueda2" >
                    <label>Estado del Turno*</label>
                    <select id="estado" name="estadoTurno">
                        <option value="En espera">En espera</option>
                        <option value="Ya atendido">Ya atendido</option>
                    </select>
                    <button type="submit" name="boton" value="botonFechaEstado">Listar todos los Turnos por fecha concreta y estado</button>
                </div>
                
            </form>
        </section>
        
    </body>
</html>

