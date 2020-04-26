import java.util.*;

public abstract class RideRepository {
    public abstract void addRides(String userId, List<? extends Ride> rides);
    public abstract Ride[] getRides(String userId);
}
