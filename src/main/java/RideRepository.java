import java.util.*;

public abstract class RideRepository {
    public abstract void addRides(String userId, List<Ride> rides);
    public abstract List<Ride> getRides(String userId);
}
