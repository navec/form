package fr.arolla;

/**
 *
 */
public class Price {
    private int cents;

    public Price(int cents){
        this.cents=cents;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
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
}
