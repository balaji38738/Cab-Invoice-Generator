import java.util.*;

public class RideRepositoryInMemory extends RideRepository{
    Map<String, List<Ride>> userRides = null;

    public RideRepositoryInMemory() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, List<Ride> rides) {
        if (this.userRides.containsKey(userId)) {
            this.userRides.get(userId).addAll(rides);
        } else {
            this.userRides.put(userId, rides);
        }
    }

    public List<Ride> getRides(String userId) {
        return this.userRides.get(userId);
    }
}
