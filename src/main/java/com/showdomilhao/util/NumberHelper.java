package com.showdomilhao.util;

public class NumberHelper {

    private NumberHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
