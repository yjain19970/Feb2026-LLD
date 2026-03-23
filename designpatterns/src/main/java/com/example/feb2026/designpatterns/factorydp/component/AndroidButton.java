package com.example.feb2026.designpatterns.factorydp.component;

public class AndroidButton implements Button {

    @Override
    public void changeSize() {
        System.out.println("AndroidButton: changeSize()");
    }

    @Override
    public void changeColor() {
         System.out.println("AndroidButton: changeColor()");
    }
    
}
