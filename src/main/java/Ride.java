public abstract class Ride {
    public int time;
    public double distance;
    public CabRide cabRide;

    public Ride(CabRide cabRide, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }

    public abstract void printRide ();
}
