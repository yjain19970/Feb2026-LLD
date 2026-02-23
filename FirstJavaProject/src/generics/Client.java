package generics;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Pair c1 = new Pair();
        c1.x = "Yash";
        c1.y = 11.13232;


        // assume that you want to create a object with firstName and lastName.
        Pair p2 = new Pair();
        p2.x = "Yash";
        p2.y = true;

        // TypeCast my X and Y.


        GenericPair<String,Integer> genericPair1 = new GenericPair<>();
        genericPair1.key = "Yash";
        genericPair1.value = 29 ;


        GenericPair<String,String> genericPair2 = new GenericPair<>();
        genericPair2.key = "Yash";
        genericPair2.value = "Jain";

        Double doubleOutput =  GenericPair.doAnything(10101.232);

        Boolean doubleOutput2 =  GenericPair.doAnythingTwo(10101.232, true);
        
        


        List<Integer> x;
        Map<String,String> yy;






        


    }


    public static void doSomething(String firstName, String lastName){
        System.out.println("FName" + firstName + " LName: " + lastName);
    }
    
}
