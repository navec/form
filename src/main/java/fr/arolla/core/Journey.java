package fr.arolla.core;

/**
 *
 */
public class Journey {

    private final String cardNumber;
    private final TypeZone typeZone;

    public Journey(String cardNumber, TypeZone typeZone) {
        this.cardNumber = cardNumber;
        this.typeZone = typeZone;
    }


    public String getCardNumber() {
        return cardNumber;
    }


    public TypeZone getType() {
        return typeZone;
    }
}
