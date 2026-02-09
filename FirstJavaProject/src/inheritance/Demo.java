package inheritance;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User("Yash", "y@gmail.com", "password");

        Employee e1 = new Employee("Emp1");
        System.out.println(e1.email);

        Instructor instructor = new Instructor("Yash", "y@gmail.com", "password", 5.0f);
        System.out.println(instructor.email);
        System.out.println(instructor.name);
        System.out.println(instructor.rating);




        Student s1 = new Student();
        s1.psp = 10.2;

        System.out.println( "Student Email: " + s1.email);
        System.out.println( "Student Name: " + s1.name);








    }
}
