package jose.pruebatecnica2.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jose.pruebatecnica2.logica.Controladora;

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
        
        control.aniadirCiudadano(request.getParameter("nombreCiudadano"),
                request.getParameter("apellidoCiudadano"),
                request.getParameter("dniCiudadano"));

        control.aniadirTurno(request.getParameter("fechaTurno"),
                request.getParameter("descripcionTramite"),
                request.getParameter("nombreCiudadano"),
                request.getParameter("apellidoCiudadano"),
                request.getParameter("dniCiudadano"));
        
        response.sendRedirect("index.jsp");
    }
    
}
