import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    private LocalDate loanDate; // To track the date the book was loaned

    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false;
        this.loanDate = null;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public String getCategory() {
        return category;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public void loanBook() {
        this.isOnLoan = true;
        this.loanDate = LocalDate.now(); // Set the loan date to today's date
    }

    public void returnBook() {
        this.isOnLoan = false;
        this.loanDate = null; // Reset the loan date
    }

    @Override
    public String toString() {
        return String.format("%s by %s, %d (%s, %d pages)", title, author, publicationYear, category, pages);
    }
}
