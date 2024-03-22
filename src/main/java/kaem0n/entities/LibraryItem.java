package kaem0n.entities;

import kaem0n.Library;

public abstract class LibraryItem {
    protected String isbn;
    protected String title;
    protected int publicationYear;
    protected int pages;

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
