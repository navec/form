package fr.arolla.food;

import java.util.List;

/**
 *
 */
public class Recipes {

    public static <INGREDIENT extends Ingredient> void cook (List<INGREDIENT> ingredients){

    }

    public static <INGREDIENT extends Ingredient & Vegetable> void cookForVegetarian (List<INGREDIENT> ingredients){

    }
}