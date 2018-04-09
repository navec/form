package fr.arolla;

import java.time.LocalDateTime;

/**
 *
 */
public class Journey {

    /** le numero de carte **/
    private String id;

    /** la date du voyage **/
    private LocalDateTime date;
    /** le type de trajet :
     * 1: zone 1
     * 2: zone 2
     * 3: zone 3
     * 4: zone 4
     * 5: Feniculaire
     * 6: Navette Aeroport
     **/
    private String type;
    /** prix calculé **/
    private Price price;
    private Price billablePrice;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setBillablePrice(Price billablePrice) {
        this.billablePrice = billablePrice;
    }

    public Price getPrice() {
        return price;
    }

    public Price getBillablePrice() {
        return billablePrice;
    }
}
