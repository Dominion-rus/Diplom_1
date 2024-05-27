package org.praktikum;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class BurgerTests {
    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = mock(Bun.class);
        mockIngredient1 = mock(Ingredient.class);
        mockIngredient2 = mock(Ingredient.class);
    }

    @Test
    public void verifySetBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void verifyAddIngredientTest() {
        burger.addIngredient(mockIngredient1);
        assertTrue(burger.ingredients.contains(mockIngredient1));
    }

    @Test
    public void verifyRemoveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(mockIngredient1));
    }

    @Test
    public void verifyMoveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient1, burger.ingredients.get(1));
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void verifyGetPriceTest() {
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockIngredient1.getPrice()).thenReturn(1.0f);
        when(mockIngredient2.getPrice()).thenReturn(1.5f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = 2.0f * 2 + 1.0f + 1.5f;
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void verifyGetReceiptTest() {
        when(mockBun.getName()).thenReturn("Bun");
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockIngredient1.getName()).thenReturn("Ingredient1");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getPrice()).thenReturn(1.0f);
        when(mockIngredient2.getName()).thenReturn("Ingredient2");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getPrice()).thenReturn(1.5f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                "Bun",
                "filling", "Ingredient1",
                "sauce", "Ingredient2",
                "Bun",
                burger.getPrice()
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
