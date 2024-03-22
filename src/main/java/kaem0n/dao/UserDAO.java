package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kaem0n.entities.User;
import kaem0n.exceptions.NotFoundException;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) { this.em = em; }

    public void save(User user) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(user);
        tr.commit();
        System.out.println("Success! User " + user.getCardId() + " is now registered!");
    }

    public User findById(long id) {
        User user = em.find(User.class, id);
        if (user == null) throw new NotFoundException(id);
        else return user;
    }
}
