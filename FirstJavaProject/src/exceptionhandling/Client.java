package exceptionhandling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    Object databse;
    
    public static void main(String[] args) throws InternalServerError {
        
        Client client = new Client();
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        
        try{
         System.out.println(client.divideByNumber(100));
         System.out.println(client.divideByNumber(10));
         System.out.println(client.divideByNumber(1));
         System.out.println(client.divideByNumber(0)); // AT THIS LINE. 19
         System.out.println(client.divideByNumber(50));


         try{
            System.out.println(client.divideByNumber(0)); 
         }catch(Exception e){

         }
         // executorService....

        }catch(Exception e){
            // This block will be ONLY excecuted when their is an exception
            // in the try.
            throw new InternalServerError("Some problem happened.");
        }finally{
            // Will always execute.
            // whether their is an exception OR their is no Exception..
             // will ALWAYS execute...
            
            System.out.println("Executing finally....");
            executorService.shutdown();


            // used to generally close down on any connections that you may have created.

            // File object, you may want to close it.
            // DB connection, you may want to close it.
            
        }

        // In case of exception, This will never execute now .. because if any exception
        // happens, we are returning a custom exception from catch block.
        System.out.println(client.divideByNumber(15));


        // Multiple catch blocks for try


        try{
            System.out.println(client.divideByNumber(0)); 
        }catch(NullPointerException e){
            // DONT THROW EXCEPTIONS FROM HERE .... 
        }catch(ArithmeticException e){
                System.out.println("WRONG INPUT.....");
        }catch(Exception e){

        }finally{
            // WILL EXECUTE ALWAYS.....
        }


        /**
         * 
         * 
         * 
         * 
         * 
         * 
         */

        // will never execute..
        //  -> in such cases, finally wont be executed. `system.exit(0)`


    }


    public double divideByNumber(int x) throws InternalServerError{
        try{
            System.out.println("Input: " + x);
            return 100/x;
        }catch(ArithmeticException e){
            throw new InternalServerError("exception happened");
        }
        
    }
}
