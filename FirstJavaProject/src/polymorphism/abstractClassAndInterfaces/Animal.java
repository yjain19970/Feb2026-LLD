package polymorphism.abstractClassAndInterfaces;

public interface Animal {
    void sleep();
    void eat();

    // from Java8. 
    default void someDefMethod(){
        System.out.println("some method.....");
    }
}
