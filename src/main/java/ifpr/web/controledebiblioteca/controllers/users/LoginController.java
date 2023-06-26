package ifpr.web.controledebiblioteca.controllers.users;

import ifpr.web.controledebiblioteca.services.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "LoginController",value = ("/login"))
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/library");
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginService loginService = new LoginService();

        try{
            loginService.validateLogin(email, password, request);
            request.getRequestDispatcher("/users");
        } catch (Exception e) {
            String msg = "Error a login: " + e.getMessage();
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/library");
        }
    }
}
