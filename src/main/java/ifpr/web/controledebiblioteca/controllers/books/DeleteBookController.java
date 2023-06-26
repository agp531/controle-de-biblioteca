package ifpr.web.controledebiblioteca.controllers.books;

import ifpr.web.controledebiblioteca.domains.models.Book;
import ifpr.web.controledebiblioteca.repository.BookRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteBookController", value = "/book/delete")
public class DeleteBookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        BookRepository bookRepository = new BookRepository();
        Book book = bookRepository.findById(Long.parseLong(id));
        bookRepository.remove(book);

        response.sendRedirect("/library");
    }

}
