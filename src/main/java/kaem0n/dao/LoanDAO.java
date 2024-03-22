package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import kaem0n.entities.Loan;

import java.util.List;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em) { this.em = em; }

    public void save(Loan loan) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(loan);
        tr.commit();
        System.out.println("Success! Loan for user " + loan.getUser().getCardId() + " has been registered!");
    }

    public List<Loan> findExpidedLoans() {
        TypedQuery<Loan> query = em.createNamedQuery("findExpiredLoans", Loan.class);
        return query.getResultList();
    }
}
