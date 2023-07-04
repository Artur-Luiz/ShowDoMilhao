package com.showdomilhao.util;

import java.security.SecureRandom;
import java.util.Collection;

public class RandomUtils {

    private static final SecureRandom RANDOM = new SecureRandom();

    private RandomUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int randomInt(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    public static <T> T getRandomElement(Collection<T> collection) {
        if (collection.isEmpty())
            return null;

        return collection.stream().skip(RANDOM.nextInt(collection.size())).findFirst().orElse(null);
    }



}
