import java.util.*;

public class RideRepositoryExcel extends RideRepository {
    Map<String, List<Ride>> userRides = null;

    public RideRepositoryExcel() {
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
