package com.example.feb2026.designpatterns.factorydp;

// This is a factory class, and is reponsible for all new changes in platform.
// This is called as PRACTICAL FACTORY.
public class UIFactoryFactory {

    public static UIFactory getUIFactory(String platform){
        if(platform == "Android"){
            return new AndroidUIFactory();
        }else if(platform =="ios"){
            return new IosUIFactory();
        }
        return null;
    }    
}




/*

1. FactoryMethod: a method in an interface which returns another interface. (object of specific child class)

2. AbstractFactory: an Interface which is collection of all factoryMethods together

3. PracticalFactory: whenever multiple vairants are available, and you need to create
                    instance of any one of them using  some logic (our case it was platform input)
                        you use PracticalFactory.

*/
