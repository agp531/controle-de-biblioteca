package ifpr.web.controledebiblioteca.connections;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {


    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
    }

    public static EntityManager getConnection(){
        return entityManagerFactory.createEntityManager();
    }

}
