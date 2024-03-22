package kaem0n;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Library {
    public static final Faker faker = new Faker();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("ok");
    }
}
