package org.praktikum;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void verifyAvailableBunsTest() {
        List<Bun> buns = database.availableBuns();

        assertNotNull(buns);
        assertEquals(3, buns.size());

        assertEquals("black bun", buns.get(0).getName());
        assertEquals(100, buns.get(0).getPrice(), 0.001f);

        assertEquals("white bun", buns.get(1).getName());
        assertEquals(200, buns.get(1).getPrice(), 0.001f);

        assertEquals("red bun", buns.get(2).getName());
        assertEquals(300, buns.get(2).getPrice(), 0.001f);
    }

    @Test
    public void verifyAvailableIngredientsTest() {
        List<Ingredient> ingredients = database.availableIngredients();

        assertNotNull(ingredients);
        assertEquals(6, ingredients.size());

        assertEquals(IngredientType.SAUCE, ingredients.get(0).getType());
        assertEquals("hot sauce", ingredients.get(0).getName());
        assertEquals(100, ingredients.get(0).getPrice(), 0.001f);

        assertEquals(IngredientType.SAUCE, ingredients.get(1).getType());
        assertEquals("sour cream", ingredients.get(1).getName());
        assertEquals(200, ingredients.get(1).getPrice(), 0.001f);

        assertEquals(IngredientType.SAUCE, ingredients.get(2).getType());
        assertEquals("chili sauce", ingredients.get(2).getName());
        assertEquals(300, ingredients.get(2).getPrice(), 0.001f);

        assertEquals(IngredientType.FILLING, ingredients.get(3).getType());
        assertEquals("cutlet", ingredients.get(3).getName());
        assertEquals(100, ingredients.get(3).getPrice(), 0.001f);

        assertEquals(IngredientType.FILLING, ingredients.get(4).getType());
        assertEquals("dinosaur", ingredients.get(4).getName());
        assertEquals(200, ingredients.get(4).getPrice(), 0.001f);

        assertEquals(IngredientType.FILLING, ingredients.get(5).getType());
        assertEquals("sausage", ingredients.get(5).getName());
        assertEquals(300, ingredients.get(5).getPrice(), 0.001f);
    }
}