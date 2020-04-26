import java.util.*;

public class RideRepositoryInMemory extends RideRepository{
    Map<String, List<? extends Ride>> userRides = null;

    public RideRepositoryInMemory() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, List<? extends Ride> rides) {
        if (this.userRides.containsKey(userId)) {
            this.userRides.get(userId).addAll(rides);
        } else {
            this.userRides.put(userId, rides);
        }
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
