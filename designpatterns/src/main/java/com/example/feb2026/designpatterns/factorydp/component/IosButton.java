package com.example.feb2026.designpatterns.factorydp.component;

public class IosButton implements Button {

    @Override
    public void changeSize() {
        System.out.println("IoSButton: changeSize()");
    }

    @Override
    public void changeColor() {
        System.out.println("IoSButton: changeColor()");
    }
    
}
