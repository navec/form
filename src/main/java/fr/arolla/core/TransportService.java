package fr.arolla.core;

/**
 *
 */
public class TransportService {

    private final Custumers custumesIbm;

    public TransportService(Custumers custumesIbm) {
        this.custumesIbm = custumesIbm;
    }

    public JourneyPrice receive(Journey journey) {
        Custumer custumer = custumesIbm.get(journey.getCardNumber());
        Price travelPrice = getZonePrice(journey);
        Price billablePrice = getBillablePrice(custumer, travelPrice);
        return new JourneyPrice(journey, travelPrice, billablePrice);
    }

    private Price getZonePrice(Journey journey) {
        Price travelPrice = new Price(9999);
        switch (journey.getType()) {
            case ZONE_1:
                travelPrice = new Price(110);
                break;
            case ZONE_2:
                travelPrice = new Price(125);
                break;
            case ZONE_3:
                travelPrice = new Price(130);
                break;
            case ZONE_4:
                travelPrice = new Price(240);
                break;
            case FENICULAIRE:
                travelPrice = new Price(650);
                break;
            case NAVETTE_AEROPORT:
                travelPrice = new Price(800);
                break;
        }
        if (travelPrice.getCents() == 9999) {
            throw new IllegalArgumentException("invalid journey type");
        }
        return travelPrice;
    }


    private Price getBillablePrice(Custumer custumer, Price cents) {
        Discount discount = null;
        switch (custumer.getProfileCustomer()) {
            case PROFILE_1:
                discount = new Discount(0);
                break;
            case PROFILE_2:
                discount = new Discount(3);
                break;
            case PROFILE_3:
                discount = new Discount(5 );
                break;
            case PROFILE_4:
                discount = new Discount(10);
                break;
        }
        return discount.apply(cents);
    }

}
