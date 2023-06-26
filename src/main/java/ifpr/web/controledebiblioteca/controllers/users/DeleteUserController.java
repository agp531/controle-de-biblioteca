package ifpr.web.controledebiblioteca.controllers.users;

import ifpr.web.controledebiblioteca.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteUserController", value = "/delete")
public class DeleteUserController extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");

            try {
                UserRepository userRepository = new UserRepository();
                userRepository.remove(userRepository.findById(Long.parseLong(id)));
                request.setAttribute("msg", "User deleted succesfull!");
                response.sendRedirect("/users");
            } catch (Exception e) {
                request.setAttribute("mensagem", "Error deleting an user: " + e.getMessage());
                response.sendRedirect("/users");
            }
        }
}

