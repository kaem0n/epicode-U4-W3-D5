package kaem0n;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kaem0n.dao.LibraryItemDAO;
import kaem0n.dao.LoanDAO;
import kaem0n.dao.UserDAO;
import kaem0n.entities.Book;
import kaem0n.entities.Loan;
import kaem0n.entities.Magazine;
import kaem0n.entities.User;
import kaem0n.enums.BookGenre;
import kaem0n.enums.PublicationSchedule;

import java.time.LocalDate;

public class Library {
    public static final Faker faker = new Faker();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        LibraryItemDAO lid = new LibraryItemDAO(em);
        LoanDAO ld = new LoanDAO(em);
        UserDAO ud = new UserDAO(em);

//        ud.save(new User("Mario", "Rossi", LocalDate.parse("1990-12-04")));
//        ud.save(new User("Maria", "Bianchi", LocalDate.parse("1995-05-15")));
//        ud.save(new User("Giovanni", "Neri", LocalDate.parse("1982-07-31")));
//
//        lid.save(new Book(faker.book().title(), 1985, 300, faker.book().author(), BookGenre.FANTASY));
//        lid.save(new Book(faker.book().title(), 2001, 250, faker.book().author(), BookGenre.CRIME));
//        lid.save(new Book(faker.book().title(), 2022, 400, faker.book().author(), BookGenre.FICTION));
//        lid.save(new Book(faker.book().title(), 2005, 150, faker.book().author(), BookGenre.HORROR));
//        lid.save(new Book(faker.book().title(), 1999, 120, faker.book().author(), BookGenre.ROMANCE));
//        lid.save(new Magazine(faker.company().industry(), 2005, 50, PublicationSchedule.WEEKLY));
//        lid.save(new Magazine(faker.company().industry(), 1999, 60, PublicationSchedule.MONTHLY));
//        lid.save(new Magazine(faker.company().industry(), 1974, 40, PublicationSchedule.SEMIANNUALLY));
//        lid.save(new Book(faker.book().title(), 1985, 300, "Cherlyn Roob", BookGenre.FANTASY));
//        lid.save(new Book(faker.book().title(), 1985, 300, "Cherlyn Roob", BookGenre.FANTASY));
//
//        ld.save(new Loan(ud.findById(1), lid.findItemByISBN("978-0-7461-8607-7"), LocalDate.parse("2024-01-03")));
//        ld.save(new Loan(ud.findById(1), lid.findItemByISBN("979-0-204-23215-4"), LocalDate.parse("2024-03-03")));
//        ld.save(new Loan(ud.findById(2), lid.findItemByISBN("978-0-7461-8607-7"), LocalDate.parse("2024-02-28")));
//        ld.save(new Loan(ud.findById(3), lid.findItemByISBN("979-0-204-23215-4"), LocalDate.parse("2024-02-04")));
//        ld.save(new Loan(ud.findById(2), lid.findItemByISBN("979-1-7559-6835-6"), LocalDate.parse("2024-01-28")));


//        lid.findItemsByYear(2005).forEach(System.out::println);
//        lid.findBooksByAuthor("Cherlyn Roob").forEach(System.out::println);
//        lid.findBooksByAuthor("Cherlyn Roob".toLowerCase()).forEach(System.out::println);
//        lid.findBooksByAuthor("Cherlyn Roob".toUpperCase()).forEach(System.out::println);
//        lid.findByTitle("to").forEach(System.out::println);
//        ld.findExpidedLoans().forEach(System.out::println);
        lid.findBorrowedItems(1).forEach(System.out::println);
        lid.findBorrowedItems(2).forEach(System.out::println);
        lid.findBorrowedItems(3).forEach(System.out::println);

//        ld.findById(5).returnItem(em);
    }
}
