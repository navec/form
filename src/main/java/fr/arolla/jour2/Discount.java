package fr.arolla.jour2;

/**
 *
 */
public class Discount {

    private final int percentage;

    private Discount(int percentages){
        this.percentage=percentages;
    }

    public static Discount fromPercentage(int percentage){
        return new Discount(percentage);
    }

    public Price applyOn(Price price){
        return price.multiplyBy(percentage).divideBy(100);
    }

}
