package jose.pruebatecnica2.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
@WebServlet("/EditarTurnoSv")
public class EditarTurnoSv extends HttpServlet {
    
    Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ciudadano ciudadano = new Ciudadano();
        Turno turno = new Turno();

        ciudadano.setNombre(request.getParameter("nombreCiudadano"));
        ciudadano.setApellido(request.getParameter("apellidoCiudadano"));
        ciudadano.setDni(request.getParameter("dniCiudadano"));

        turno.setId(Long.parseLong(request.getParameter("idTurno")));
        turno.setFecha(LocalDate.parse(request.getParameter("fechaTurno")));
        turno.setDescripcion(request.getParameter("descripcionTurno"));
        turno.setEstado(request.getParameter("estadoTurno"));
        turno.setCiudadano(ciudadano);
        
        control.editarTurno(turno);

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
