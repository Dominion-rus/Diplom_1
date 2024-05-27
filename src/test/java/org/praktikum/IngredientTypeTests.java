package org.praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTests {

    @Test
    public void verifyGetOrderSauceTest() {
        assertEquals(0,IngredientType.SAUCE.ordinal());
    }
    @Test
    public void verifyGetOrderFillingTest() {
        assertEquals(1, IngredientType.FILLING.ordinal());
    }
}
