package fr.arolla.core;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class JourneyPrice {

    private final Journey journey;
    private final Price priceComputed;
    private final Price billablePrice;

    public JourneyPrice(Journey journey, Price priceComputed, Price billablePrice) {
        this.journey = journey;
        this.priceComputed = priceComputed;
        this.billablePrice = billablePrice;
    }

    public Journey getJourney() {
        return journey;
    }

    public Price getPriceComputed() {
        return priceComputed;
    }

    public Price getBillablePrice() {
        return billablePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JourneyPrice that = (JourneyPrice) o;

        if (!journey.equals(that.journey)) return false;
        if (!priceComputed.equals(that.priceComputed)) return false;
        return billablePrice.equals(that.billablePrice);
    }

    @Override
    public int hashCode() {
        int result = journey.hashCode();
        result = 31 * result + priceComputed.hashCode();
        result = 31 * result + billablePrice.hashCode();
        return result;
    }
}
