import java.util.List;

public class InvoiceService {
    private RideRepository rideRepository;

    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public InvoiceSummary calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.cabRide.calcCostOfCabRide(ride);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public void addRides(String userId, List<Ride> rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

}
