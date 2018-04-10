package fr.arolla.core;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public enum TypeZone {
    ZONE_1("1"), ZONE_2("2"),ZONE_3("3"), ZONE_4("4"), FENICULAIRE("5"), NAVETTE_AEROPORT("6");

    private final String type;

    TypeZone(String type) {
        this.type = type;
    }
}
