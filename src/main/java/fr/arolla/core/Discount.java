package fr.arolla.core;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class Discount {
    private final int percentage;

    public Discount(int percentage) {
        this.percentage = percentage;
    }

    public Price apply(Price price) {
        return new Price(price.getCents() - price.getCents() * percentage / 100);
    }
}
