package oopsLab1;

class Librarian extends User {
    private String employeeNumber;

    // Constructors
    public Librarian(String name, String contactInfo, String employeeNumber) {
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Librarian Dashboard");
        System.out.println("Employee Number: " + employeeNumber);
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    // currently Object, it has to be Book dataType
    public void addNewBook(Object book) {
        // Implementation for adding a book
    }

    // currently Object, it has to be Book dataType
    public void removeBook(Object book) {
        // Implementation for removing a book
    }
}
