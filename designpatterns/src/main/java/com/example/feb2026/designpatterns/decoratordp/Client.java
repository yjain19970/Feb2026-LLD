package com.example.feb2026.designpatterns.decoratordp;

public class Client {
    public static void main(String[] args) {
        IceCreamConstituents iceCreamConstituents = 
            new ChocolateScoop(new ChocolateCone(new ChocolateCone()));
        
        System.out.println("COST: " + iceCreamConstituents.getCost() 
        + " AND DESCRIPTION: " + iceCreamConstituents.getDescription());
    }
}
