package com.example.feb2026.designpatterns.decoratordp;

// BaseClass
public class ChocolateCone implements IceCreamConstituents {
    IceCreamConstituents iceCreamConstituents;

    
    // This will be called when there is NO cone selected before this cone
    public ChocolateCone(){}

    // This will be called when there's already one cone.
    public ChocolateCone(IceCreamConstituents iceCreamConstituents){
        this.iceCreamConstituents = iceCreamConstituents;
    }

    @Override
    public double getCost() {
        if(iceCreamConstituents ==null){
            // RETURN THE COST OF SELF CONE ONLY.
            return 20;
        }
        // THAT MEANS: RETURN COST OF PREV ICE CREAM + THIS ONE.
        return 20 + iceCreamConstituents.getCost();
    }

    @Override
    public String getDescription() {
        if(iceCreamConstituents ==null){
            return "CHOCOLATE CONE";
        }
        return "CHOCOLATE CONE" + iceCreamConstituents.getDescription();
    }

}
