package generics;

public class GenericTrio<T,U,V> {
    T first;
    U second;
    V third;
    public GenericTrio(){}
    
    public GenericTrio(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }
    public U getSecond() {
        return second;
    }
    public V getThird() {
        return third;
    }


    
    
}
