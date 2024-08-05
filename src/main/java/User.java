import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> borrowedBooks;
    private double lateFees;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.borrowedBooks = new ArrayList<>();
        this.lateFees = 0.0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public double getLateFees() {
        return lateFees;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void accrueLateFees(double amount) {
        lateFees += amount;
    }

    public void payFees(double amount) {
        lateFees = Math.max(0, lateFees - amount);
    }

    @Override
    public String toString() {
        return String.format("%s (Card: %s) - %d books borrowed, $%.2f in late fees", name, libraryCardNumber, borrowedBooks.size(), lateFees);
    }
}
