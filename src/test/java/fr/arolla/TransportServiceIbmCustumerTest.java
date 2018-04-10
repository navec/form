package fr.arolla;

import fr.arolla.core.Journey;
import fr.arolla.core.JourneyPrice;
import fr.arolla.core.TypeZone;
import fr.arolla.infra.CustumesIbm;
import fr.arolla.core.TransportService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TransportServiceIbmCustumerTest {

    CustumesIbm custumersIbm = new CustumesIbm();

    @Test
    public void test_receive_journey(){
        // Given
        TransportService service = new TransportService(custumersIbm);
        Journey journey = new Journey("562390865", TypeZone.ZONE_1);

        // When
        JourneyPrice journeyPrice = service.receive(journey);

        // Then
        assertEquals(110,journeyPrice.getPriceComputed().getCents());
        assertEquals(107,journeyPrice.getBillablePrice().getCents());
    }

    @Test
    public void test_receive_journey_2(){
        // Given
        TransportService service = new TransportService(custumersIbm);
        Journey journey = new Journey("562390865",  TypeZone.ZONE_3);

        // When
        JourneyPrice journeyPrice = service.receive(journey);

        // Then
        assertEquals(130,journeyPrice.getPriceComputed().getCents());
        assertEquals(127,journeyPrice.getBillablePrice().getCents());
    }
}