import java.time.LocalDate; // Import the LocalDate class for date handling

public class Book {
    // Private fields to store book details
    private String title; // Title of the book
    private String author; // Author of the book
    private int publicationYear; // Year the book was published
    private int pages; // Number of pages in the book
    private String category; // Category or genre of the book
    private boolean isOnLoan; // Flag to indicate if the book is currently on loan
    private LocalDate loanDate; // Date when the book was loaned

    // Constructor to initialize a new Book object with the provided details
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title; // Set the title
        this.author = author; // Set the author
        this.publicationYear = publicationYear; // Set the publication year
        this.pages = pages; // Set the number of pages
        this.category = category; // Set the category
        this.isOnLoan = false; // Initialize isOnLoan to false, meaning the book is not on loan
        this.loanDate = null; // Initialize loanDate to null, meaning no loan date is set
    }

    // Getters to retrieve the values of the private fields
    public String getTitle() {
        return title; // Return the title of the book
    }

    public String getAuthor() {
        return author; // Return the author of the book
    }

    public int getPublicationYear() {
        return publicationYear; // Return the publication year of the book
    }

    public int getPages() {
        return pages; // Return the number of pages in the book
    }

    public String getCategory() {
        return category; // Return the category of the book
    }

    public boolean isOnLoan() {
        return isOnLoan; // Return whether the book is currently on loan
    }

    public LocalDate getLoanDate() {
        return loanDate; // Return the date the book was loaned, if any
    }

    // Setter to update the loanDate
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate; // Set the loan date to the provided date
    }

    // Method to mark the book as loaned
    public void loanBook() {
        this.isOnLoan = true; // Set isOnLoan to true, indicating the book is now on loan
        this.loanDate = LocalDate.now(); // Set loanDate to the current date
    }

    // Method to mark the book as returned
    public void returnBook() {
        this.isOnLoan = false; // Set isOnLoan to false, indicating the book is no longer on loan
        this.loanDate = null; // Clear the loanDate as the book is returned
    }

    // Override the toString method to provide a formatted string representation of the book
    @Override
    public String toString() {
        return String.format("%s by %s, %d (%s, %d pages)", title, author, publicationYear, category, pages);
        // Return a formatted string with the book's title, author, publication year, category, and number of pages
    }
}

/*
 * Summary:
 * The Book class represents a book with attributes such as title, author, publication year,
 * number of pages, category, loan status, and loan date. It provides methods to loan and
 * return the book, along with getters and setters to access and modify the book's details.
 * The toString method provides a formatted string representation of the book's information.
 */
