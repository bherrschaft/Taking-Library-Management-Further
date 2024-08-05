import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book from the library by title
    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    // Find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Find the book with the most pages
    public Optional<Book> findBookWithMostPages() {
        return books.stream().max((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()));
    }

    // Find all books with more than n pages
    public List<Book> findBooksMoreThanPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    // Print all book titles in the library, sorted alphabetically
    public void printAllBookTitles() {
        books.stream()
                .map(Book::getTitle)
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);
    }

    // Find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Loan a book to a user
    public boolean loanBook(String title, User user) {
        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan())
                .findFirst();

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.loanBook();
            user.addBorrowedBook(book);
            return true;
        }
        return false;
    }

    // Return a book from a user
    public boolean returnBook(String title, User user) {
        Optional<Book> bookOptional = user.getBorrowedBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getLoanDate() != null) {
                long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());
                if (daysOnLoan > 14) {
                    user.accrueLateFees((daysOnLoan - 14) * 0.5); // $0.5 per day after 2 weeks
                }
            }
            book.returnBook();
            user.removeBorrowedBook(book);
            return true;
        }
        return false;
    }

    // Register a new user
    public void registerUser(User user) {
        users.add(user);
    }

    // Find a user by library card number
    public Optional<User> findUserByCardNumber(String cardNumber) {
        return users.stream()
                .filter(user -> user.getLibraryCardNumber().equalsIgnoreCase(cardNumber))
                .findFirst();
    }
}
