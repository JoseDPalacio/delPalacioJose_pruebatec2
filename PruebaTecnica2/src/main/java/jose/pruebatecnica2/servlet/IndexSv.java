/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jose.pruebatecnica2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jose.pruebatecnica2.logica.Ciudadano;
import jose.pruebatecnica2.logica.Controladora;
import jose.pruebatecnica2.logica.Turno;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "IndexSv", urlPatterns = {"/IndexSv"})
public class IndexSv extends HttpServlet {

    private Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String botonPulsado = request.getParameter("boton");
        
        if (botonPulsado.equals("botonFecha")){
            LocalDate fecha = LocalDate.parse(request.getParameter("fechaBusqueda"));
            request.setAttribute("resultados", control.verTurnosFecha(fecha));
        } else{
            LocalDate fecha = LocalDate.parse(request.getParameter("fechaBusqueda2"));
            String estado = request.getParameter("estadoTurno");
            request.setAttribute("resultados", control.verTurnosFiltrado(fecha, estado));
        }
        
        
        
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String botonPulsado = request.getParameter("boton");
        if (botonPulsado.equals("boton1")) {
            response.sendRedirect("crearTurno.jsp");

        } else if (botonPulsado.equals("botonModificar")) {
            Ciudadano ciudadano = new Ciudadano();
            Turno turno = new Turno();
            
            ciudadano.setNombre(request.getParameter("nombreCiudadano"));
            ciudadano.setApellido(request.getParameter("apellidoCiudadano"));
            ciudadano.setDni(request.getParameter("dniCiudadano"));
            
            turno.setId(Long.parseLong(request.getParameter("idTurno")));
            turno.setFecha(LocalDate.parse(request.getParameter("fechaTurno")));
            turno.setDescripcion(request.getParameter("descripcionTurno"));
            turno.setEstado("Ya atendido");
            turno.setCiudadano(ciudadano);
            
            request.setAttribute("turno", turno);
            request.getRequestDispatcher("modificarTurno.jsp").forward(request, response);
        }
    }

}
