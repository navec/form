package fr.arolla.jour2;

/**
 *
 */
public class Price {
    private int cents;

    private Price(int cents){
        this.cents=cents;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public String toString() {
        return "Price{" +
                "cents=" + cents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        return cents == price.cents;

    }

    @Override
    public int hashCode() {
        return cents;
    }

    public Price add(Price price) {
        return new Price(price.getCents()+this.cents);
    }

    public Price minus(Price price) {
        return new Price(this.cents-price.getCents());
    }

    public Price multiplyBy(int multiplicateur) {
        return Price.fromCents(this.cents*multiplicateur);
    }

    public static Price fromCents(int cents) {
        return new Price(cents);
    }

    public Price divideBy(int divisor) {
        return Price.fromCents(this.cents/divisor);
    }
}
