package jose.pruebatecnica2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jose.pruebatecnica2.logica.Controladora;

@WebServlet("/EditarTurnoSv")
public class EditarTurnoSv extends HttpServlet {

    Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        control.editarTurnoRecogido(request.getParameter("idTurno"),
                        request.getParameter("fechaTurno"),
                        request.getParameter("descripcionTurno"),
                        request.getParameter("estadoTurno"),
                        request.getParameter("nombreCiudadano"),
                        request.getParameter("apellidoCiudadano"),
                        request.getParameter("dniCiudadano"));

        response.sendRedirect("index.jsp");
    }

}
