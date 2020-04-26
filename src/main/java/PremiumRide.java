public class PremiumRide extends Ride{

    public PremiumRide(CabRide cabRide, double distance, int time) {
        super(cabRide, distance, time);
    }

    public void printRide () {
        System.out.println("Premium class");
    }
}
