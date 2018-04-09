package fr.arolla;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TransportServiceTest {


    @Test
    public void test_receive_journey(){
        TransportService service = new TransportService();
        Journey journey = new Journey();
        journey.setId("562390865");
        journey.setType("1");
        journey = service.receive(journey);
        assertEquals(110,journey.getPrice().getCents());
        assertEquals(107,journey.getBillablePrice().getCents());
    }

    @Test
    public void test_receive_journey_2(){
        TransportService service = new TransportService();
        Journey journey = new Journey();
        journey.setId("562390865");
        journey.setType("3");
        journey = service.receive(journey);
        assertEquals(130,journey.getPrice().getCents());
        assertEquals(127,journey.getBillablePrice().getCents());
    }
}