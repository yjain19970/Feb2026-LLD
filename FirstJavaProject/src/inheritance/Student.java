package inheritance;

public class Student extends User {

    double psp;

    public Student(String name, String email, String pwd, double psp) {
        super(name, email, pwd); // VERY FIRST LINE IN THIS CONSTRUCTOR.

        this.psp = psp;
    }

    

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    
    
}
