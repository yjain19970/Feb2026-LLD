package com.example.feb2026.designpatterns.factorydp;

import com.example.feb2026.designpatterns.factorydp.component.AndroidButton;
import com.example.feb2026.designpatterns.factorydp.component.Button;
import com.example.feb2026.designpatterns.factorydp.component.Menu;

public class AndroidUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return null; // ToDo: Implement it later.
    }
    
}
