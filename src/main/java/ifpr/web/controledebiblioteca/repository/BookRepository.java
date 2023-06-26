package ifpr.web.controledebiblioteca.repository;

import ifpr.web.controledebiblioteca.connections.ConnectionFactory;
import ifpr.web.controledebiblioteca.domains.models.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class BookRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public BookRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Book create(Book book){
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        return book;
    }

    public Book findById(Long id){
        Book book = entityManager.find(Book.class, id);

        return book;
    }

    public Book update(Book book){

        transaction.begin();

        book = entityManager.merge(book);

        transaction.commit();

        return book;

    }

    public Book remove(Book book){
        if(book == null){
            throw new RuntimeException("Book can't be null");
        }

        transaction.begin();
        book = entityManager.find(Book.class, book.getId());
        entityManager.remove(book);
        transaction.commit();

        return book;
    }

    public List<Book> findAll(){

        return entityManager.
                createQuery("SELECT b FROM book b", Book.class).
                getResultList();
    }

}
