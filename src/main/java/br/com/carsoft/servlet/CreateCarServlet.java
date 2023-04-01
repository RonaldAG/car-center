package br.com.carsoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {

        String carName = servletRequest.getParameter("car");
        System.out.println("Car name: " + carName);

        //Seta o atributo para ser enviado na próxima página
        servletRequest.setAttribute("carName", carName);

        servletRequest.getRequestDispatcher("secondPage.jsp").forward(servletRequest, servletResponse);
    }
}
