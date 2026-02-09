package polymorphism.abstractClassAndInterfaces;

public class Demo {
    public static void main(String[] args) {
        //User user = new User();

        User user2 = new Student("yash", 27);
        System.out.println(user2.getAge());
        user2.login();

    }
}
