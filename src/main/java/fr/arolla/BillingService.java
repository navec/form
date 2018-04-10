package fr.arolla;

import java.util.Collection;

/**
 *
 */
public class BillingService {

    private Travels travels;
    private TransportService transportService;

    public BillingService(Travels travels,TransportService transport) {
        this.travels = travels;
        this.transportService=transport;
    }

    public Price getBillableAmount(String cardNumber){
        Collection<Journey> journeys = travels.all();
        Price price = new Price(0);
        Price discount = new Price(0);
        for (Journey journey : journeys) {
            if(journey.getId().equals(cardNumber)){
                Journey billableJourney = transportService.receive(journey);
                price = price.add(billableJourney.getPrice());
                if(!billableJourney.getPrice().equals(billableJourney.getBillablePrice())){
                    discount=discount.add(billableJourney.getPrice().minus(billableJourney.getBillablePrice()));
                }
            }
        }
        System.out.println(price+" ("+discount+" )");
        return price;
    }
}
