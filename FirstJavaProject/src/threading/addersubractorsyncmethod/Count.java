package threading.addersubractorsyncmethod;

public class Count {
    private int value = 0;

    public int getValue() {
        return value;
    }

    // -1: subractor
    // +1 : adder 
    public synchronized void syncIncreamentValue(int offset){
        this.value += offset;
    }
    

}
