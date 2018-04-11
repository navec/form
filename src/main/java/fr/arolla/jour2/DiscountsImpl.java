package fr.arolla.jour2;

/**
 * Created by lenovo_9 on 11/04/2018.
 */
public class DiscountsImpl implements Discounts {

    @Override
    public Discount getDiscount(Customer customer) {
        if(customer.getProfile().equals("P6")){
            return Discount.fromPercentage(15);
        }
        if(customer.getProfile().equals("P5")){
            return Discount.fromPercentage(12);
        }
        if(customer.getProfile().equals("P4")){
            return Discount.fromPercentage(10);
        }
        if(customer.getProfile().equals("P3")){
            return Discount.fromPercentage(5);
        }
        if(customer.getProfile().equals("P2")){
            return Discount.fromPercentage(3);
        }
        if(customer.getProfile().equals("P1")){
            return Discount.fromPercentage(10);
        }
        throw new IllegalArgumentException(customer.getProfile());
    }
}
