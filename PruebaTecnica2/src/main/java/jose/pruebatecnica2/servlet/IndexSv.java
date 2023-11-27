/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jose.pruebatecnica2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jose.pruebatecnica2.logica.Controladora;

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
        request.setAttribute("resultados", control.verTurnos());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String botonPulsado = request.getParameter("boton");
        if (botonPulsado.equals("boton1")) {
            response.sendRedirect("crearTurno.jsp");
        
        } else if (botonPulsado.equals("botonModificar")) {
            response.sendRedirect("");
        }
    }

}
