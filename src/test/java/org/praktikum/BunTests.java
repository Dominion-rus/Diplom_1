package org.praktikum;

import static org.junit.Assert.*;
import org.junit.Test;

public class BunTests {
    @Test
    public void  verifyGetNameTest() {
        Bun bun = new Bun("сырная булка", 13);
        assertEquals("сырная булка", bun.getName());
    }

    @Test
    public void verifyGetNameReturnsEmptyTest() {
        Bun bun = new Bun("", 25);
        assertEquals("", bun.getName());
    }
    @Test
    public void verifyGetPriceIsPositiveTest() {
        Bun bun = new Bun("сырная булка", 13.5f);
        assertEquals(13.5f, bun.getPrice(), 0.001);
    }
    @Test
    public void verifyGetPriceIsNegativeTest() {
        Bun bun = new Bun("сырная булка", -16.1f);
        assertEquals(-16.1f, bun.getPrice(), 0.001);
    }
    @Test
    public void verifyGetPriceIsZeroTest() {
        Bun bun = new Bun("сырная булка", 0.0f);
        assertEquals(0.0f, bun.getPrice(), 0.001);
    }

    @Test
    public void verifyGetNameReturnsNullTest() {
        Bun bun = new Bun(null, 20);
        assertNull(bun.getName());
    }

}
