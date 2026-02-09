package inheritance;

public class User {
    String name;
    String email;
    String pwd;


    void doSomething(){
        System.out.println("Do something in user...");
    }

    

    public User(String name, String email, String pwd) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
    }

    public User(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    
}
