package ifpr.web.controledebiblioteca.controllers.users;

import ifpr.web.controledebiblioteca.domains.enums.TypeUsers;
import ifpr.web.controledebiblioteca.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CreateUserController", value = "/user/create")
public class CreateUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TypeUsers> type = Arrays.asList(TypeUsers.values());
        request.setAttribute("type", type);
        request.getRequestDispatcher("/users/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UserService userService = new UserService();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        try{
            userService.create_user(name, email, password, type);
            response.sendRedirect("/users");
        } catch (Exception e) {
            String msg = "Error creating a new user: " + e.getMessage();
            response.sendRedirect( "/users?msg=" + URLEncoder.encode(msg, StandardCharsets.UTF_8));
        }
    }
}
