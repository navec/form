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
    private Discounts discounts;
    private Prices prices;

    public BillingService(Travels travels, InvoiceNotifier notifier, Discounts discounts, Prices prices) {
        this.travels = travels;
        this.notifier = notifier;
        this.discounts = discounts;
        this.prices = prices;
    }

    public DiscountedPrice getBillableAmount(String cardNumber) {
        Collection<Journey> journeys = travels.all();
        Customer customer = customers.retrieveByCardNumber(cardNumber);
        Discount discount = discounts.getDiscount(customer);
        DiscountedPrice discountedPrice = journeys.stream().filter(journey -> journey.getId().equals(cardNumber))
                .map(journey -> prices.getPrice(journey))
                .map(price -> DiscountedPrice.from(price, discount.applyOn(price)))
                .reduce(DiscountedPrice.from(Price.fromCents(0), Price.fromCents(0)), DiscountedPrice::add);


        System.out.println(discountedPrice);
        notifier.notify(cardNumber, discountedPrice);
        return discountedPrice;
    }

    public static class DiscountedPrice{

        private final Price price;
        private final Price priceDiscounted;

        private DiscountedPrice(Price price, Price priceDiscounted) {
            this.price = price;
            this.priceDiscounted = priceDiscounted;
        }

        public Price getPrice() {
            return price;
        }

        public Price getPriceDiscounted() {
            return priceDiscounted;
        }

        public DiscountedPrice add(DiscountedPrice discountedPrice) {
            return new DiscountedPrice(discountedPrice.price.add(this.price),
                    discountedPrice.priceDiscounted.add(this.priceDiscounted));
        }

        public static DiscountedPrice from(Price price, Price priceDiscounted) {
            return new DiscountedPrice(price, priceDiscounted);
        }
    }

}
