package com.example.feb2026.designpatterns.factorydp;

import com.example.feb2026.designpatterns.factorydp.component.Button;
import com.example.feb2026.designpatterns.factorydp.component.IosButton;
import com.example.feb2026.designpatterns.factorydp.component.Menu;

public class IosUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public Menu createMenu() {
        return null; // ToDo: Implement it by yourself.
    }
    
}
