package oopsLab1;

abstract class Book implements Lendable {
     String isbn;
     String title;
     String author;
     boolean isAvailable;

    // Default constructor
    public Book() {
        this.isAvailable = true;
    }
    // Parameterized constructor
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    // Copy constructor
    public Book(Book other) {
        this.isbn = other.isbn;
        this.title = other.title;
        this.author = other.author;
        this.isAvailable = other.isAvailable;
    }

    @Override
    public boolean lend(User user) {
        if (isAvailable && user.canBorrowBooks()) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public void returnBook(User user) {
        isAvailable = true;
        // Decrease the borroewed book count from here.....
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    // Abstract method
    public abstract void displayBookDetails();
}
