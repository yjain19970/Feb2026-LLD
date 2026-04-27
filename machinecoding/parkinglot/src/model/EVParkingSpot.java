package parkinglot.src.model;

public class EVParkingSpot extends ParkingSpot {
    public EVParkingSpot(int spotNumber) {
        super(spotNumber);
    }

    private Meter meter;

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }
    
}
