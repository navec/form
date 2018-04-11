package fr.arolla.jour2;

import fr.arolla.Journey;
import fr.arolla.Travels;

import java.util.Collection;

/**
 *
 */
public class BillingService {

    private Travels travels;
    private Customers customers = new Customers();
    private InvoiceNotifier notifier;

    public BillingService(Travels travels) {
        this.travels = travels;
    }

    public Price getBillableAmount(String cardNumber){
        Collection<Journey> journeys = travels.all();

        Price price = Price.fromCents(0);

        for (Journey journey : journeys)
            if (journey.getId().equals(cardNumber)) {
                Customer customer = customers.retrieveByCardNumber(journey.getId());
                Discount discount = getDiscount(customer);
                price = price.add(discount.applyOn(getPrice(journey)));
            }
        System.out.println(price);
        notifier.notify(cardNumber,price);
        return price;
    }

    private Price getPrice(Journey journey) {

        if(journey.getType().equals("1")){
            return Price.fromCents(110);
        }
        if(journey.getType().equals("2")){
            return Price.fromCents(125);
        }
        if(journey.getType().equals("3")){
            return Price.fromCents(130);
        }
        if(journey.getType().equals("4")){
            return Price.fromCents(240);
        }
        if(journey.getType().equals("5")){
            return Price.fromCents(650);
        }
        if(journey.getType().equals("6")){
            return Price.fromCents(800);
        }
        throw new IllegalArgumentException("invalid journey type");
    }


    private Discount getDiscount(Customer info) {
        if(info.getProfile().equals("P6")){
            return Discount.fromPercentage(15);
        }
        if(info.getProfile().equals("P5")){
            return Discount.fromPercentage(12);
        }
        if(info.getProfile().equals("P4")){
            return Discount.fromPercentage(10);
        }
        if(info.getProfile().equals("P3")){
            return Discount.fromPercentage(5);
        }
        if(info.getProfile().equals("P2")){
            return Discount.fromPercentage(3);
        }
        if(info.getProfile().equals("P1")){
            return Discount.fromPercentage(10);
        }
        throw new IllegalArgumentException(info.getProfile());
    }

}
