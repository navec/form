package fr.arolla.generique;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class Recipe<E> {

    private E value;

    private Recipe(E value) {
        this.value = value;
    }

    public final static <E extends Ingredient>Recipe<E> from (E item){
        return new Recipe<E>(item);
    }

    public final static <E extends Ingredient & Vegetale>Recipe<E> fromVegetale (E item){
        return new Recipe<E>(item);
    }

    public E getIngredien() {
        return value;
    }
}
