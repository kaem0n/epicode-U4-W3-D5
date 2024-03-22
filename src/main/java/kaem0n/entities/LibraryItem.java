package kaem0n.entities;

import jakarta.persistence.*;
import kaem0n.Library;

import java.util.List;

@Entity
@Table(name = "library_items")
@Inheritance(strategy = InheritanceType.JOINED)
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
