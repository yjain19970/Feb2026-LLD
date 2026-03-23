package com.example.feb2026.designpatterns.factorydp;

import com.example.feb2026.designpatterns.factorydp.component.Button;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        // I have to create an ANDROID BUTTON.
        // It should be very simply for me to switch from Android to IoS.

        UIFactory uiFactory =  flutter.getUIFactory("ios"); // you get it from your configFile.
        // methods for button,menu
        Button button =  uiFactory.createButton();
        button.changeColor();
        button.changeSize();
    }
}
