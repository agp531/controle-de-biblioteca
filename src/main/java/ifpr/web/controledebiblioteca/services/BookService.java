package ifpr.web.controledebiblioteca.services;

import ifpr.web.controledebiblioteca.domains.enums.BookStatus;
import ifpr.web.controledebiblioteca.domains.models.Author;
import ifpr.web.controledebiblioteca.domains.models.Book;
import ifpr.web.controledebiblioteca.repository.AuthorRepository;
import ifpr.web.controledebiblioteca.repository.BookRepository;

import java.time.LocalDate;

public class BookService {

    private BookRepository bookRepository = new BookRepository();
    private AuthorRepository authorRepository = new AuthorRepository();


    public void create_book(String name, String authorName, String status) {

        if(name == null || name.isEmpty()) {
            throw new RuntimeException("Name not be null");
        }

        if(authorName == null || authorName.isEmpty()) {
            throw new RuntimeException("Author name not be null");
        }

        if(status == null || status.isEmpty()) {
            throw new RuntimeException("Status not be null");
        }

        BookStatus bookStatus = BookStatus.valueOf(status);


        if(status == null) {
            throw new RuntimeException("Wrong Status");
        }

        try {
            Book book = new Book();
            Author author = new Author();
            author.setName(authorName);
            book.setName(name);
            book.setAuthor(authorRepository.create(author));
            book.setBookStatus(bookStatus);
            book.setDate(LocalDate.now());

            bookRepository.create(book);

        } catch (Exception e) {
            throw new RuntimeException("Error creating a new book.");
        }

    }
}
