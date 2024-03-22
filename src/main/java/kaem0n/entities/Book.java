package kaem0n.entities;

import jakarta.persistence.*;
import kaem0n.enums.BookGenre;

@Entity
@Table(name = "books")
@NamedQuery(name = "findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")
public class Book extends LibraryItem {
    private String author;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;

    public Book() {}

    public Book(String title, int publicationYear, int pages, String author, BookGenre genre) {
        super(title, publicationYear, pages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
