package com.example.feb2026.designpatterns.factorydp;

public class Flutter {
    public void setTheme(){
        System.out.println("Setting theme...");
    }

    public void setRefreshRate(){
        System.out.println("Setting theme...");
    }

    // This flutter class -- should support -- all type of buttons to be created.

    // getDatabase();
    public UIFactory getUIFactory(String platform){
       return UIFactoryFactory.getUIFactory(platform);
    }

}
