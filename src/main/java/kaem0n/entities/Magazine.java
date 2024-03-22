package kaem0n.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import kaem0n.enums.PublicationSchedule;

@Entity
@Table(name = "magazines")
public class Magazine extends LibraryItem {
    @Enumerated(EnumType.STRING)
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
