import demoAccessmodifiers.Instructor;

public class Student {
    public String name;
    public String emailAddress;
    public Integer age;
    public Integer batchId;
    public Integer id;

    String someDefaultVar;


    // methods
    public void sayHello(){
        System.out.println("Say hello!");
    }

    public String sayBye(){
        return "say Bye!";
    }
    // getters and setters. --

    public static void main(String[] args) {
        Student ankit = new Student();
        ankit.age = 25;
        ankit.batchId = 101;
        ankit.id = 100234;
        ankit.emailAddress = "ankit@gmail.com";
        ankit.name = "Ankit";

        System.out.println("Ankit's Age: " + ankit.age);
        System.out.println("Ankit's batchId: " + ankit.batchId);
        System.out.println("Ankit ---> " + ankit);
        // toString() --> just learn about it later as HW.
        // how to print data of object using toString();

        Student kavin = new Student();
        kavin.age = 27;
        kavin.batchId = 101;
        kavin.id = 293847;
        kavin.emailAddress = "kavin@gmail.com";
        kavin.name = "Kavin";

        System.out.println("Kavin's Age: " + kavin.age);
        System.out.println("Kavin's batchId: " + kavin.batchId);
        System.out.println("Kavin ---> " + kavin);


        Student ankitCopy = ankit; // A NEW OBJECT IS NOT CREATED....



        Instructor instructor = new Instructor();
        //instructor.instructorName = "jsds";

    }
    
    
    /**
    

    BankAccount
     - balance
     - ownerName


     withdraw(double amount){
     }

     deposit(){
     }
    */
}
