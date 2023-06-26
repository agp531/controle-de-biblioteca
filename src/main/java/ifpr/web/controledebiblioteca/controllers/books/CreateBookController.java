package ifpr.web.controledebiblioteca.controllers.books;


import ifpr.web.controledebiblioteca.domains.enums.BookStatus;
import ifpr.web.controledebiblioteca.repository.AuthorRepository;
import ifpr.web.controledebiblioteca.services.BookService;
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

@WebServlet(name = "CreateBookController", value = "/book/create")
public class CreateBookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookStatus> bookStatus = Arrays.asList(BookStatus.values());
        request.setAttribute("bookStatus", bookStatus);
        request.getRequestDispatcher("/library/create.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BookService bookService = new BookService();

        String name = request.getParameter("name");
        String authorName = request.getParameter("authorName");
        String status = request.getParameter("status");

        try {
            bookService.create_book(name, authorName, status);
            response.sendRedirect("/library");
        } catch (Exception e) {
            String mensagem = "Error creating a new book: " + e.getMessage();
            response.sendRedirect("/library?mensagem=" + URLEncoder.encode(mensagem, StandardCharsets.UTF_8));
        }
    }

}
