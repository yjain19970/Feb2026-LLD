package oopsLab1;

public class LendableImpl implements Lendable  {

    @Override
    public boolean lend(User user) {
        return true;
    }

    @Override
    public void returnBook(User user) {
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    public static void main(String[] args) {
        // Parent p = new Child();

        // Interface acts as a Parent. Book is-A Lendable. 
        Lendable lendable = new LendableImpl();

    }
    
}
