package kaem0n.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "isbn")
    private LibraryItem item;
    @Column(name = "loan_date")
    private LocalDate loanDate;
    @Column(name = "loan_expiration")
    private LocalDate loanExpiration;
    @Column(name = "return_date")
    private LocalDate returnDate;

    public Loan() {}

    public Loan(User user, LibraryItem item, LocalDate loanDate) {
        this.user = user;
        this.item = item;
        this.loanDate = loanDate;
        this.loanExpiration = loanDate.plusDays(30);
        this.returnDate = null;
    }

    public User getUser() {
        return user;
    }

    public LibraryItem getItem() {
        return item;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getLoanExpiration() {
        return loanExpiration;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "user=" + user +
                ", item=" + item +
                ", loanDate=" + loanDate +
                ", loanExpiration=" + loanExpiration +
                ", returnDate=" + returnDate +
                '}';
    }
}
