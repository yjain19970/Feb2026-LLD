package oopsLab1;

interface Lendable {
    boolean lend(User user);
    void returnBook(User user);
    boolean isAvailable();
}

