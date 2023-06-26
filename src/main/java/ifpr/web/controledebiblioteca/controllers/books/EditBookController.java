package ifpr.web.controledebiblioteca.controllers.books;

import ifpr.web.controledebiblioteca.domains.enums.BookStatus;
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
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "EditBookController",value = "/book/edit")
public class EditBookController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();

        Book book = bookRepository.findById(Long.parseLong(id));
        request.setAttribute("book", book);

        Author author = authorRepository.findById(Long.parseLong(id));
        request.setAttribute("author", author);

        List<BookStatus> bookStatus = Arrays.asList(BookStatus.values());

        request.setAttribute("status", bookStatus);

        request.getRequestDispatcher("/library/edit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String authorName = request.getParameter("authorName");

        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();

        String status = request.getParameter("status");
        BookStatus bookStatus = BookStatus.valueOf(status);

        Author authorEdit = authorRepository.findById(Long.parseLong(request.getParameter("id")));
        authorEdit.setName(authorName);
        authorRepository.update(authorEdit);

        Book book = bookRepository.findById(Long.parseLong(request.getParameter("id")));
        book.setName(name);
        book.setAuthor(authorEdit);
        book.setBookStatus(bookStatus);

        bookRepository.update(book);

        response.sendRedirect("/library");
    }


}
