public class NormalRide extends Ride{

    public NormalRide(CabRide cabRide, double distance, int time) {
        super(cabRide, distance, time);
    }

    public void printRide () {
        System.out.println("Normal class");
    }
}
