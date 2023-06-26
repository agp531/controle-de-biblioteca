package ifpr.web.controledebiblioteca.repository;

import ifpr.web.controledebiblioteca.connections.ConnectionFactory;
import ifpr.web.controledebiblioteca.domains.models.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AuthorRepository {


    private EntityManager entityManager;
    private EntityTransaction transaction;

    public AuthorRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Author create (Author author){

        transaction.begin();
        entityManager.persist(author);
        transaction.commit();

        return  author;
    }

    public Author findById(Long id){
        Author author = entityManager.find(Author.class, id);

        return author;
    }

    public Author update(Author author){

        transaction.begin();

        author = entityManager.merge(author);

        transaction.commit();

        return author;
    }

    public Author remove(Author author){

        if(author == null){
            throw new RuntimeException("Author não pode ser nulo");
        }
        transaction.begin();
        author = entityManager.find(Author.class,author.getId());
        entityManager.remove(author);
        transaction.commit();

        return author;
    }

    public List<Author> findAll(){
        return entityManager.createQuery("SELECT a FROM author a", Author.class).getResultList();
    }

}
