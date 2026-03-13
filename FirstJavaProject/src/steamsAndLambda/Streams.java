package steamsAndLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        // stream - very powerful feature from Java8.
        // provides methods for data manipulation.



        List<Integer> list = List.of(2, 7, 3, 4, 6, 6, 10, 1, 9, 8, 9, 12);
        List<Integer> divisbleByTwo = new ArrayList<>();
        for(Integer l : list){
            if(l%2 ==0){
                divisbleByTwo.add(l);
            }
        }
        
        
        List<Integer> finalList = 
                list.stream()
                    .filter((x) -> x%2==0)
                        .sorted()
                            .collect(Collectors.toList());

        System.out.println("Output: " + finalList);
        // [2,4,6,6]
        // [4,16,36,36]

        // map() -- intermediate method. taken input process it and returns output.

        Function<Integer,Integer> f = (input) -> input*input;

        List<Integer> output =  list.stream()
            .filter(x -> x%2==0)
                    .map((x) -> x*x).distinct().collect(Collectors.toList());
        
        System.out.println("SQUARE: " + output);



        /*
            filter
            distint
            stream()
            map()
            collect(Collectors.toList() / toSet())
        
        */
    }
}
