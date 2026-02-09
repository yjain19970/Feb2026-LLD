package polymorphism;

public class A {
    String nameA;

    void sayHello(){
        System.out.println("Class A");
    }    

    void sayHello(String name){
        System.out.println("Class A: " + name);
    }

    void sayHello(String lastName, String fName){
        System.out.println("Class A: " + lastName + " and : " + fName);
    }



    public static void main(String[] args) {
        A a = new B(); 
        a.sayHello(); // 
        // a.sayHello("yash");
        // a.sayHello("yash", "jain");

    }
}
