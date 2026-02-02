package demoAccessmodifiers;

import java.util.ArrayList;
import java.util.List;

public class Instructor {
    String instructorName; // null 
    int age; // 0
    public List<Integer> emails; // null


    public Instructor(){
        this.age = 10;
        this.instructorName = "";
        this.emails = new ArrayList<>();
    }
    


    public static void main(String[] args) {
        Instructor instructor = new Instructor();

        instructor.age = 100;
        
        System.out.println("name: " + instructor.instructorName);
        System.out.println("age: " + instructor.age);

        Instructor instructor2 = new Instructor();
        // default will kick in...
    }
}
