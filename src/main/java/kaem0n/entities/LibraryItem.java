package kaem0n.entities;

import jakarta.persistence.*;
import kaem0n.Library;

import java.util.List;

@Entity
@Table(name = "library_items")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "findByYear", query = "SELECT li FROM LibraryItem li WHERE li.publicationYear = :year")
@NamedQuery(name = "findByTitle", query = "SELECT li FROM LibraryItem li WHERE LOWER(li.title) LIKE LOWER(:title)")
//@NamedQuery(name = "findBorrowedItems",
//        query = "SELECT li FROM LibraryItem li " +
//                "JOIN Loan l ON li = l.item" +
//                "JOIN User u ON u = l.user")
public abstract class LibraryItem {
    @Id
    protected String isbn;
    protected String title;
    @Column(name = "publication_year")
    protected int publicationYear;
    protected int pages;
    @OneToMany(mappedBy = "item")
    protected List<Loan> loans;

    protected LibraryItem() {}

    protected LibraryItem(String title, int publicationYear, int pages) {
        this.isbn = Library.faker.code().isbn13(true);
        this.title = title;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                '}';
    }
}
