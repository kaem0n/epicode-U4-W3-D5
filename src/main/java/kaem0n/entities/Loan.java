package kaem0n.entities;

import java.time.LocalDate;

public class Loan {
    private User user;
    private LibraryItem item;
    private LocalDate loanDate;
    private LocalDate loanExpiration;
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
