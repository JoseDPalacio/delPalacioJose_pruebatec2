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
        
        
        String nombreC = request.getParameter("nombreCiudadano");
        String apellidoC = request.getParameter("apellidoCiudadano");
        String dniC = request.getParameter("dniCiudadano");
        control.aniadirCiudadano(nombreC, apellidoC, dniC);
        
        LocalDate fecha = LocalDate.parse(request.getParameter("fechaTurno"), formatter);
        String descripcion = request.getParameter("descripcionTramite");
        
        control.aniadirTurno(fecha, descripcion, nombreC, apellidoC, dniC);
        
        response.sendRedirect("index.jsp");
    }
    
}
