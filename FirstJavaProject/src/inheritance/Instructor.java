package inheritance;

public class Instructor extends User {
    float rating;
    

    public Instructor(String email, String pwd, float rating) {
        super(email,pwd); // HAS TO BE FIRST LINE.
        this.rating = rating;
    }

    public Instructor(float rating) {
        super("email", "pwd"); // HAS TO BE FIRST LINE.
        this.rating = rating;
    }    

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    
}

/*
(Parent)A -> B -> C -> D


D d = new D();



D- > C -> B> A 



*/