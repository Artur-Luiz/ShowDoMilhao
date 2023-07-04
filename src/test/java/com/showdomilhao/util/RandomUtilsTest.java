package com.showdomilhao.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @Test
    void randomInt() {
        for (int i = 0; i < 100; i++) {
            int value = RandomUtils.randomInt(0, 10);
            assertTrue(value >= 0 && value <= 10, "Value is not between 0 and 10");
        }
    }

    @Test
    void getRandomElement() {
        for (int i = 0; i < 100; i++) {
            String value = RandomUtils.getRandomElement(Arrays.asList("a", "b", "c"));
            assertNotNull(value, "Value is null");
            assertTrue(value.equals("a") || value.equals("b") || value.equals("c"), "Value is not a, b or c");
        }
    }

    @Test
    void getRandomElementWithEmptyList() {
        assertNull(RandomUtils.getRandomElement(List.of()));
    }

}