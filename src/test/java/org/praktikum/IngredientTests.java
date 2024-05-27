package org.praktikum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IngredientTests {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "Салат", 0.5f);
    }

    @Test
    public void verifyGetPriceTest() {
        assertEquals(0.5f, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void verifyGetNameTest() {
        assertEquals("Салат", ingredient.getName());
    }

    @Test
    public void verifyGetTypeTest() {
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
