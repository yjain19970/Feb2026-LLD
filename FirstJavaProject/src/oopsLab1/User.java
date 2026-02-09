package oopsLab1;

abstract class User {
    private static int idCounter = 0;
    private static int totalUsers = 0;
    private final String userId;
    private String name;
    private String contactInfo;

    // Default constructor
    public User() {
        this.userId = generateUniqueId();
        totalUsers++;
    }

    // Parameterized constructor
    public User(String name, String contactInfo) {
        this.userId = generateUniqueId();
        this.name = name;
        this.contactInfo = contactInfo;
        totalUsers++;
    }

    // Copy constructor
    public User(User other) {
        this.userId = other.userId;
        this.name = other.name;
        this.contactInfo = other.contactInfo;
        totalUsers++;
    }

    // Generate a unique ID (for now, returns incrementing ID as a string)
    public final static String generateUniqueId() {
        return String.valueOf(++idCounter);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getUserId() {
        return userId;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    // Abstract methods
    public abstract void displayDashboard();
    public abstract boolean canBorrowBooks();

    // public static void main(String[] args) {
    //     User.generateUniqueId();
    //     User.getTotalUsers();
    // }
}