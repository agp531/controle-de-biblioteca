package ifpr.web.controledebiblioteca.repository;

import ifpr.web.controledebiblioteca.connections.ConnectionFactory;
import ifpr.web.controledebiblioteca.domains.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;

public class UserRepository {

    private EntityManager entityManager;

    public UserRepository(){
        this.entityManager = ConnectionFactory.getConnection();
    }

    public User findById(Long id){
        return entityManager.find(User.class,id);
    }

    public List<User> findAll(){
        Query query = entityManager.createNativeQuery("select * from tb_users", User.class );
        List<User> users = query.getResultList();

        return users;
    }


    public User findByEmail(String email) throws NoResultException {
        return entityManager.createQuery("SELECT u FROM tb_users u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public User create(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        return  user;
    }

    public void remove(User user){
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }


    public void update(User user){
        entityManager.getTransaction().begin();

        user = entityManager.merge(user);

        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

}
