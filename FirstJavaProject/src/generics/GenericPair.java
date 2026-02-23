package generics;

// T: String, V: Integer.
public class GenericPair<T,V> {
    public T key;
    public V value;


    public T f9;
    public T f19;
    public T f119;
    public T f11w9;
    public T f1119;

    public GenericPair(T key, V value) {
        this.key = key;
        this.value = value;
    }


    public GenericPair(){}

    public T getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }


    // static: It can help you create var and methods and access them w/o objects.

    // Generic method looks like
    public V doSomething(T data1, T data2){
        System.out.println("do anything....");
        return null;
    }


    // static methods: they are associated to a class and not Object.
    // X: Anything.. Float/ String/ Integer / Double.
    public static <X> X doAnything(X data){
        return null;
    }

        // static methods: they are associated to a class and not Object.
    // X: Anything.. Float/ String/ Integer / Double.
    public static <X,T> Boolean doAnythingTwo(X data, T data2){
        return null;
    }


    
}
