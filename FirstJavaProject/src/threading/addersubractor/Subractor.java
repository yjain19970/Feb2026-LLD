package threading.addersubractor;

public class Subractor implements Runnable{
    private Count count;

    public Subractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            count.value -= 1;
        }
    }
}
