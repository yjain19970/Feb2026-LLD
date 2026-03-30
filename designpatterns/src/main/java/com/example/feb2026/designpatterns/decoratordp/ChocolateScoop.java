package com.example.feb2026.designpatterns.decoratordp;

/*
Add-On class.
Cannot exist INDEPENDENTLY...
*/
public class ChocolateScoop implements IceCreamConstituents {
    private IceCreamConstituents iceCreamConstituents;

    public ChocolateScoop(IceCreamConstituents iceCreamConstituents){
        if(iceCreamConstituents ==null){
            throw new IllegalArgumentException("BASE ADD-ON is MUST!");
        }
        this.iceCreamConstituents = iceCreamConstituents;
    }

    @Override
    public double getCost() {
        return 100 + iceCreamConstituents.getCost();
    }

    @Override
    public String getDescription() {
        return "CHOCOLATE SCOOP" + iceCreamConstituents.getDescription();
    }
    
}
