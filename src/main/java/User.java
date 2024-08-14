import java.util.ArrayList; // Import the ArrayList class for dynamic array operations
import java.util.List; // Import the List interface for working with lists

public class User {
    // Private fields to store user information
    private String name; // The name of the user
    private String libraryCardNumber; // The user's library card number
    private List<Book> borrowedBooks; // A list to store books borrowed by the user
    private double lateFees; // The total amount of late fees owed by the user

    // Constructor to initialize a new User object with the provided name and library card number
    public User(String name, String libraryCardNumber) {
        this.name = name; // Set the user's name
        this.libraryCardNumber = libraryCardNumber; // Set the user's library card number
        this.borrowedBooks = new ArrayList<>(); // Initialize an empty list for borrowed books
        this.lateFees = 0.0; // Initialize late fees to 0.0
    }

    // Getters to retrieve the values of the private fields
    public String getName() {
        return name; // Return the name of the user
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber; // Return the library card number of the user
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks; // Return the list of books borrowed by the user
    }

    public double getLateFees() {
        return lateFees; // Return the total late fees owed by the user
    }

    // Method to add a book to the user's borrowed books list
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book); // Add the provided book to the borrowedBooks list
    }

    // Method to remove a book from the user's borrowed books list
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book); // Remove the provided book from the borrowedBooks list
    }

    // Method to accrue late fees for the user
    public void accrueLateFees(double amount) {
        lateFees += amount; // Add the provided amount to the user's total late fees
    }

    // Method to allow the user to pay off late fees
    public void payFees(double amount) {
        lateFees = Math.max(0, lateFees - amount); // Subtract the payment from the total late fees, ensuring it doesn't go below zero
    }

    // Override the toString method to provide a formatted string representation of the user
    @Override
    public String toString() {
        return String.format("%s (Card: %s) - %d books borrowed, $%.2f in late fees", name, libraryCardNumber, borrowedBooks.size(), lateFees);
        // Return a formatted string with the user's name, library card number, number of borrowed books, and total late fees
    }
}

/*
 * Summary:
 * The User class represents a library user with attributes such as name, library card number,
 * a list of borrowed books, and accrued late fees. It provides methods to manage the user's
 * borrowed books, accrue and pay off late fees, and retrieve user information. The toString
 * method gives a formatted summary of the user's current status, including the number of books
 * borrowed and the amount of late fees owed.
 */
