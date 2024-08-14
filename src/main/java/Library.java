import java.time.LocalDate; // Import the LocalDate class for date handling
import java.time.temporal.ChronoUnit; // Import the ChronoUnit class for calculating date differences
import java.util.ArrayList; // Import the ArrayList class for dynamic array operations
import java.util.Comparator; // Import the Comparator interface for comparing objects
import java.util.List; // Import the List interface for working with lists
import java.util.Optional; // Import the Optional class to handle possible null values
import java.util.function.Predicate; // Import the Predicate interface for functional operations
import java.util.stream.Collectors; // Import the Collectors class for collecting stream results

public class Library {
    // Fields to store the collection of books and users in the library
    private List<Book> books; // List to store books in the library
    private List<User> users; // List to store users registered in the library

    // Constructor to initialize the Library object with empty lists for books and users
    public Library() {
        this.books = new ArrayList<>(); // Initialize books list
        this.users = new ArrayList<>(); // Initialize users list
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book); // Add the provided book to the books list
    }

    // Method to remove a book from the library by its title
    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title)); // Remove books with a matching title
    }

    // Method to find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream() // Create a stream from the books list
                .filter(book -> book.getPublicationYear() == year) // Filter books by the publication year
                .collect(Collectors.toList()); // Collect and return the filtered books as a list
    }

    // Method to find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream() // Create a stream from the books list
                .filter(book -> book.getAuthor().equalsIgnoreCase(author)) // Filter books by the author
                .collect(Collectors.toList()); // Collect and return the filtered books as a list
    }

    // Method to find the book with the most pages
    public Optional<Book> findBookWithMostPages() {
        return books.stream() // Create a stream from the books list
                .max(Comparator.comparingInt(Book::getPages)); // Find the book with the maximum number of pages
    }

    // Method to find all books with more than a specified number of pages
    public List<Book> findBooksMoreThanPages(int n) {
        return books.stream() // Create a stream from the books list
                .filter(book -> book.getPages() > n) // Filter books with more than n pages
                .collect(Collectors.toList()); // Collect and return the filtered books as a list
    }

    // Method to print all book titles in the library, sorted alphabetically
    public void printAllBookTitles() {
        books.stream() // Create a stream from the books list
                .map(Book::getTitle) // Map each book to its title
                .sorted(String::compareToIgnoreCase) // Sort the titles alphabetically, ignoring case
                .forEach(System.out::println); // Print each title
    }

    // Method to find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream() // Create a stream from the books list
                .filter(book -> book.getCategory().equalsIgnoreCase(category)) // Filter books by category
                .collect(Collectors.toList()); // Collect and return the filtered books as a list
    }

    // Method to loan a book to a user
    public boolean loanBook(String title, User user) {
        Optional<Book> bookOptional = books.stream() // Create a stream from the books list
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan()) // Find the book by title and check if it's not on loan
                .findFirst(); // Get the first matching book, if any

        if (bookOptional.isPresent()) { // If a book is found
            Book book = bookOptional.get(); // Get the book from the Optional
            book.loanBook(); // Mark the book as loaned
            user.addBorrowedBook(book); // Add the book to the user's borrowed books list
            return true; // Return true indicating the loan was successful
        }
        return false; // Return false if the book was not found or already on loan
    }

    // Method to return a book from a user
    public boolean returnBook(String title, User user) {
        Optional<Book> bookOptional = user.getBorrowedBooks().stream() // Create a stream from the user's borrowed books
                .filter(book -> book.getTitle().equalsIgnoreCase(title)) // Find the book by title
                .findFirst(); // Get the first matching book, if any

        if (bookOptional.isPresent()) { // If the book is found
            Book book = bookOptional.get(); // Get the book from the Optional
            if (book.getLoanDate() != null) { // Check if the book has a loan date
                long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now()); // Calculate the number of days the book was on loan
                if (daysOnLoan > 14) { // If the book was on loan for more than 14 days
                    user.accrueLateFees((daysOnLoan - 14) * 0.5); // Charge a late fee of $0.5 per day after 2 weeks
                }
            }
            book.returnBook(); // Mark the book as returned
            user.removeBorrowedBook(book); // Remove the book from the user's borrowed books list
            return true; // Return true indicating the return was successful
        }
        return false; // Return false if the book was not found in the user's borrowed books
    }

    // Method to register a new user in the library
    public void registerUser(User user) {
        users.add(user); // Add the user to the users list
    }

    // Method to find a user by their library card number
    public Optional<User> findUserByCardNumber(String cardNumber) {
        return users.stream() // Create a stream from the users list
                .filter(user -> user.getLibraryCardNumber().equalsIgnoreCase(cardNumber)) // Find the user by card number
                .findFirst(); // Get the first matching user, if any
    }
}

/*
 * Summary:
 * The Library class manages a collection of books and users. It provides methods to add, remove, and search for books
 * by various criteria such as year, author, category, and page count. The class also handles book loans and returns,
 * including calculating late fees for overdue books. Users can be registered, and the system can find users by their
 * library card number. The class makes extensive use of Java's Stream API for filtering and processing the collections.
 */
