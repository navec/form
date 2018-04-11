package fr.arolla;

import fr.arolla.jour2.BillingService;
import fr.arolla.jour2.RandomTravels;
import org.junit.Test;

/**
 *
 */
public class BillingServiceTest {

    private BillingService service = new BillingService(new RandomTravels());

    @Test
    public void should_sum() {
        service.getBillableAmount("443454432");
    }
}