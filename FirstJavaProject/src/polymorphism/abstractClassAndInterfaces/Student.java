package polymorphism.abstractClassAndInterfaces;

public class Student extends User implements Animal {

    public Student(String name, Integer age) {
        super(name, age);
    }

    // It becomes mandatory.....
    @Override
    public void login() {
        System.out.println("Login from Student....");
    }

    @Override
    public void sleep() {
    }

    @Override
    public void eat() {
    }
    
}
