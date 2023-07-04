package com.showdomilhao.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberHelperTest {

    @Test
    void isInteger() {
        assertTrue(NumberHelper.isInteger("1"));
        assertTrue(NumberHelper.isInteger("0"));
        assertTrue(NumberHelper.isInteger("-1"));
        assertFalse(NumberHelper.isInteger("1.1"));
        assertFalse(NumberHelper.isInteger("1,1"));
        assertFalse(NumberHelper.isInteger("a"));
    }
}