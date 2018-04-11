package fr.arolla.generique;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class RecipeTest {

    @Test
    public void foo() throws Exception {
        // Given
        Ingredient ingredientExpected = new Ingredient("Beef");
        Recipe<Ingredient> recipe = Recipe.from(ingredientExpected);

        // When
        Ingredient ingredient = recipe.getIngredien();

        // Then
        assertEquals(ingredientExpected, ingredient);
    }

    @Test
    public void foo2() throws Exception {
        // Given
        Pea ingredientExpected = new Pea("Beef");
        Recipe<Pea> recipe = Recipe.fromVegetale(ingredientExpected);

        // When
        Ingredient ingredient = recipe.getIngredien();

        // Then
        assertEquals(ingredientExpected, ingredient);
    }
}