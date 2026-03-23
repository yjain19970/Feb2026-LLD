package com.example.feb2026.designpatterns.factorydp;

import com.example.feb2026.designpatterns.factorydp.component.Button;
import com.example.feb2026.designpatterns.factorydp.component.Menu;

/*
Abstract factory where it will only consist of factory methods.
*/
public interface UIFactory {
    // factoryMethod
    public Button createButton();

    // factoryMethod
    public Menu createMenu();
}


// This Interface is actually a AbstractFactory DP? 