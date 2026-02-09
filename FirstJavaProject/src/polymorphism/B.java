package polymorphism;

public class B extends A {
    public String nameB;


    // Does not follow the rule for method overriding...
    // public String sayHello(){
    //     System.out.println("Class B");
    // }

    // The below one is fine.
    public void sayHello(){
        System.out.println("Class B");
    }
}
