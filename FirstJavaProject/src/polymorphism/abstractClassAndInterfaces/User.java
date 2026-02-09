package polymorphism.abstractClassAndInterfaces;

public abstract class User {
    String name;
    Integer age;


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public abstract void login();

    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
}
