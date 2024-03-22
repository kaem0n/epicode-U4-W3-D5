package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import kaem0n.entities.Book;
import kaem0n.entities.LibraryItem;
import kaem0n.exceptions.NotFoundException;

import java.util.List;

public class LibraryItemDAO {
    private final EntityManager em;

    public LibraryItemDAO(EntityManager em) { this.em = em; }

    public void save(LibraryItem item) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(item);
        tr.commit();
        System.out.println("Success! \"" + item.getTitle() + "\" is now on the catalog!");
    }

    public LibraryItem findItemByISBN(String isbn) {
        LibraryItem item = em.find(LibraryItem.class, isbn);
        if (item == null) throw new NotFoundException(isbn);
        else return item;
    }

    public void delete(String isbn) {
        LibraryItem item = findItemByISBN(isbn);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(item);
        tr.commit();
        System.out.println("Item deleted successfully from the catalog.");
    }

    public List<LibraryItem> findItemsByYear(int year) {
        TypedQuery<LibraryItem> query = em.createNamedQuery("findByYear", LibraryItem.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<Book> findBooksByAuthor(String author) {
        TypedQuery<Book> query = em.createNamedQuery("findByAuthor", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    public List<LibraryItem> findByTitle(String title) {
        TypedQuery<LibraryItem> query = em.createNamedQuery("findByTitle", LibraryItem.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

//    public List<LibraryItem> findBorrowedItems(long userId) {
//        TypedQuery<LibraryItem> query = em.createQuery("SELECT li FROM LibraryItem li WHERE ", LibraryItem.class);
//    }
}
