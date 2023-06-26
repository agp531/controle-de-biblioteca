package ifpr.web.controledebiblioteca.controllers.users;

import ifpr.web.controledebiblioteca.domains.models.User;
import ifpr.web.controledebiblioteca.repository.UserRepository;
import ifpr.web.controledebiblioteca.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "NewUserController", value = "/users")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.findAll();
        request.setAttribute("users",users);

        String msg = (String) request.getAttribute("msg");
        request.setAttribute("msg",msg);

        request.getRequestDispatcher("/users/users.jsp").forward(request,response);
    }

}
