package jose.pruebatecnica2.servlet;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jose.pruebatecnica2.logica.Controladora;

@WebServlet(name = "IndexSv", urlPatterns = {"/IndexSv"})
public class IndexSv extends HttpServlet {

    private Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String botonPulsado = request.getParameter("boton");

        if (botonPulsado.equals("botonFecha")) {
            String fechaS = request.getParameter("fechaBusqueda1");
            if (fechaS != null && !fechaS.isEmpty()) {
                LocalDate fecha = LocalDate.parse(fechaS);
                request.setAttribute("resultados", control.verTurnosFecha(fecha));
                request.getRequestDispatcher("verTurnos.jsp").forward(request, response);
            }

        } else {
            String fechaS = request.getParameter("fechaBusqueda2");
            String estado = request.getParameter("estadoTurno");
            if (fechaS != null && !fechaS.isEmpty() && estado!=null && !estado.isEmpty()) {
                LocalDate fecha = LocalDate.parse(fechaS);
                request.setAttribute("resultados", control.verTurnosFiltrado(fecha, estado));
                request.getRequestDispatcher("verTurnos.jsp").forward(request, response);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String botonPulsado = request.getParameter("boton");
        if (botonPulsado.equals("boton1")) {
            response.sendRedirect("crearTurno.jsp");
        }
    }

}
