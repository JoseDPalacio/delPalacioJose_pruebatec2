package jose.pruebatecnica2.servlet;

import java.io.IOException;

import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jose.pruebatecnica2.logica.Ciudadano;
import jose.pruebatecnica2.logica.Turno;

@WebServlet(name = "VerTurnoSv", urlPatterns = {"/VerTurnoSv"})
public class VerTurnoSv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
