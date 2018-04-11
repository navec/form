package fr.arolla.jour2;

/**
 *
 */
public class Customer {
    private String name;
    private String lastname;
    private String profile;
    private String cardNumber;

    public Customer(String name, String lastname, String profile, String cardNumber) {
        this.name = name;
        this.lastname = lastname;
        this.profile = profile;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getProfile() {
        return profile;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
