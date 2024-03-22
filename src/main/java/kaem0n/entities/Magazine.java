package kaem0n.entities;

import kaem0n.enums.PublicationSchedule;

public class Magazine extends LibraryItem {
    private PublicationSchedule schedule;

    public Magazine() {}

    public Magazine(String title, int publicationYear, int pages, PublicationSchedule schedule) {
        super(title, publicationYear, pages);
        this.schedule = schedule;
    }

    public PublicationSchedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", schedule=" + schedule +
                '}';
    }
}
