package kaem0n.entities;

import kaem0n.enums.BookGenre;

public class Book extends LibraryItem {
    private String author;
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
