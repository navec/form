package fr.arolla;

import org.junit.Test;

/**
 *
 */
public class BillingServiceTest {

    private BillingService service = new BillingService(new RandomTravels(), new TransportService());

    @Test
    public void should_sum() {
        service.getBillableAmount("443454432");
    }
}