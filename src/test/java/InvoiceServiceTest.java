import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;
    InvoiceSummary expectedInvoiceSummary = null;
    private RideRepository rideRepository = null;
    Ride[] rides;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepositoryInMemory();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new NormalRide(CabRide.NORMAL, 2.0, 5),
                new PremiumRide(CabRide.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoice() {
        String userId = "a@b.com";
        List<Ride> rides = new ArrayList<>();
        rides.add(new NormalRide(CabRide.NORMAL, 2.0, 5));
        rides.add(new PremiumRide(CabRide.PREMIUM,  0.1, 1));

        String userId2 = "k@b.com";
        List<Ride> rides2 = new ArrayList<>();
        rides2.add(new NormalRide(CabRide.NORMAL, 3.0, 5));
        rides2.add(new PremiumRide(CabRide.PREMIUM, 0.1, 1));
        invoiceService.addRides(userId, rides);
        invoiceService.addRides(userId2, rides2);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        InvoiceSummary summary2 = invoiceService.getInvoiceSummary(userId2);
        InvoiceSummary expectedInvoiceSummary2 = new InvoiceSummary(2, 55.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
        Assert.assertEquals(expectedInvoiceSummary2, summary2);
    }
}
