import java.time.LocalDate;

public class LibraryManagementTest {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Fiction"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 212, "Science"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180, "Fiction"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281, "Fiction"));
        library.addBook(new Book("The Art of War", "Sun Tzu", 5, 273, "History"));

        // Register a user
        User user = new User("Alice Smith", "U001");
        library.registerUser(user);

        // Loan a book
        if (library.loanBook("1984", user)) {
            System.out.println("1984 has been loaned to Alice.");
        } else {
            System.out.println("1984 is not available for loan.");
        }

        // Show borrowed books
        System.out.println("Books borrowed by Alice: " + user.getBorrowedBooks());

        // Simulate 16 days passing for the borrowed book by setting the loan date to 16 days ago
        Book borrowedBook = user.getBorrowedBooks().get(0);
        borrowedBook.setLoanDate(borrowedBook.getLoanDate().minusDays(16)); // Set loan date to 16 days ago

        // Return the book
        if (library.returnBook("1984", user)) {
            System.out.println("1984 has been returned.");
        } else {
            System.out.println("1984 could not be returned.");
        }

        System.out.println("Books borrowed by Alice after returning: " + user.getBorrowedBooks());
        System.out.println("Alice's late fees: $" + user.getLateFees());

        // Find and display books
        System.out.println("Books by George Orwell: " + library.findBooksByAuthor("George Orwell"));
        System.out.println("Books published in 1949: " + library.findBooksByYear(1949));
        System.out.println("All book titles:");
        library.printAllBookTitles();

        // Additional functionality testing
        System.out.println("Books in the Fiction category: " + library.findBooksByCategory("Fiction"));
        System.out.println("Book with the most pages: " + library.findBookWithMostPages().orElse(null));
        System.out.println("Books with more than 200 pages: " + library.findBooksMoreThanPages(200));
    }
}
