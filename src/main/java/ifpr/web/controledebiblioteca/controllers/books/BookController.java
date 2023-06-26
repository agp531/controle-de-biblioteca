package ifpr.web.controledebiblioteca.controllers.books;

import ifpr.web.controledebiblioteca.domains.models.Author;
import ifpr.web.controledebiblioteca.domains.models.Book;
import ifpr.web.controledebiblioteca.repository.AuthorRepository;
import ifpr.web.controledebiblioteca.repository.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/library")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookRepository bookRepository = new BookRepository();
        List<Book> books = bookRepository.findAll();

        String msg = (String) request.getParameter("msg");
        request.setAttribute("msg", msg);

        AuthorRepository authorRepository = new AuthorRepository();
        List<Author> authors = authorRepository.findAll();

        request.setAttribute("books", books);
        request.setAttribute("authors", authors);

        request.getRequestDispatcher("/library/library.jsp").forward(request, response);
    }
}
