package fr.arolla.core;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class Custumer {

    private final String name;
    private final String prenom;
    private final ProfileCustomer profileCustomer;
    private final String cardNumber;

    public Custumer(String name, String prenom, ProfileCustomer profileCustomer, String cardNumber) {
        this.name = name;
        this.prenom = prenom;
        this.profileCustomer = profileCustomer;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public ProfileCustomer getProfileCustomer() {
        return profileCustomer;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Custumer custumer = (Custumer) o;

        if (!name.equals(custumer.name)) return false;
        if (!prenom.equals(custumer.prenom)) return false;
        if (profileCustomer != custumer.profileCustomer) return false;
        return cardNumber.equals(custumer.cardNumber);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + prenom.hashCode();
        result = 31 * result + profileCustomer.hashCode();
        result = 31 * result + cardNumber.hashCode();
        return result;
    }
}
