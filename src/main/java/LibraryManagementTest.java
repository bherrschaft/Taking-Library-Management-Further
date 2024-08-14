import java.time.LocalDate; // Import the LocalDate class for handling dates

public class LibraryManagementTest {
    public static void main(String[] args) {
        Library library = new Library(); // Create a new Library instance

        // Add some books to the library
        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Fiction")); // Add "1984" by George Orwell
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 212, "Science")); // Add "A Brief History of Time" by Stephen Hawking
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180, "Fiction")); // Add "The Great Gatsby" by F. Scott Fitzgerald
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281, "Fiction")); // Add "To Kill a Mockingbird" by Harper Lee
        library.addBook(new Book("The Art of War", "Sun Tzu", 5, 273, "History")); // Add "The Art of War" by Sun Tzu

        // Register a user in the library
        User user = new User("Alice Smith", "U001"); // Create a new User instance for Alice Smith
        library.registerUser(user); // Register Alice in the library

        // Attempt to loan the book "1984" to Alice
        if (library.loanBook("1984", user)) { // Check if the loan is successful
            System.out.println("1984 has been loaned to Alice."); // Print success message
        } else {
            System.out.println("1984 is not available for loan."); // Print failure message if the book is already on loan
        }

        // Show the books currently borrowed by Alice
        System.out.println("Books borrowed by Alice: " + user.getBorrowedBooks()); // Display the list of borrowed books

        // Simulate 16 days passing for the borrowed book by adjusting the loan date
        Book borrowedBook = user.getBorrowedBooks().get(0); // Get the first book in Alice's borrowed list
        borrowedBook.setLoanDate(borrowedBook.getLoanDate().minusDays(16)); // Set the loan date to 16 days ago

        // Attempt to return the book "1984"
        if (library.returnBook("1984", user)) { // Check if the return is successful
            System.out.println("1984 has been returned."); // Print success message
        } else {
            System.out.println("1984 could not be returned."); // Print failure message if the book was not found
        }

        // Show the books borrowed by Alice after returning "1984"
        System.out.println("Books borrowed by Alice after returning: " + user.getBorrowedBooks()); // Display the list of borrowed books after return
        System.out.println("Alice's late fees: $" + user.getLateFees()); // Display Alice's accrued late fees

        // Find and display books by various criteria
        System.out.println("Books by George Orwell: " + library.findBooksByAuthor("George Orwell")); // Display books by George Orwell
        System.out.println("Books published in 1949: " + library.findBooksByYear(1949)); // Display books published in 1949
        System.out.println("All book titles:");
        library.printAllBookTitles(); // Print all book titles in the library

        // Additional functionality testing
        System.out.println("Books in the Fiction category: " + library.findBooksByCategory("Fiction")); // Display books in the Fiction category
        System.out.println("Book with the most pages: " + library.findBookWithMostPages().orElse(null)); // Display the book with the most pages
        System.out.println("Books with more than 200 pages: " + library.findBooksMoreThanPages(200)); // Display books with more than 200 pages
    }
}

/*
 * Summary:
 * The LibraryManagementTest class tests various functionalities of the Library class, including adding books,
 * registering users, loaning and returning books, and searching for books by different criteria. The class simulates
 * user interactions and demonstrates how the library system handles loans, returns, and the accrual of late fees.
 * The program also tests the library's ability to find books by author, publication year, category, and page count.
 */
