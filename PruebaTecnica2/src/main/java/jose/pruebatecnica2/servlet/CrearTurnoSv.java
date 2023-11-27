/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jose.pruebatecnica2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "CrearTurnoSv", urlPatterns = {"/CrearTurnoSv"})
public class CrearTurnoSv extends HttpServlet {

    private Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Ciudadano ciudadano = new Ciudadano();
        Turno turno = new Turno();
        
        ciudadano.setNombre(request.getParameter("nombreCiudadano"));
        ciudadano.setApellido(request.getParameter("apellidoCiudadano"));
        ciudadano.setDni(request.getParameter("dniCiudadano"));
        Ciudadano ciudComaparador = control.verCiudadanoConcreto(ciudadano.getNombre(), ciudadano.getApellido(), ciudadano.getDni());
        if(control.verCiudadanos().isEmpty()){
            control.crearCiudadano(ciudadano);
        }else if(!ciudComaparador.getDni().equalsIgnoreCase(request.getParameter("dniCiudadano"))){
            control.crearCiudadano(ciudadano);
        }
        
        
        turno.setFecha(LocalDate.parse(request.getParameter("fechaTurno"), formatter));
        turno.setDescripcion(request.getParameter("descripcionTramite"));
        turno.setEstado("En Tramite");
        turno.setCiudadano(control.verCiudadanoConcreto(ciudadano.getNombre(), ciudadano.getApellido(), ciudadano.getDni()));
        control.crearTurno(turno);
        
        System.out.println(turno);
        response.sendRedirect("index.jsp");
    }


}
