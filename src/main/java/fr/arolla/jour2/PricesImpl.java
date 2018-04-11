package fr.arolla.jour2;

import fr.arolla.Journey;

/**
 * Created by lenovo_9 on 11/04/2018.
 */
public class PricesImpl implements Prices {

    @Override
    public Price getPrice(Journey journey) {

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
}
