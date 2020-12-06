package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomIntegers {
    /** range: [min,max)
     * ref: https://www.baeldung.com/java-generating-random-numbers */
    public static List<Integer> mathRandom(int min, int max, int qty) {
        List<Integer> rnd = new ArrayList<>();
        // since Math.random output is a double value b/w [0,1], we need to convert it to int separately
        for (int i = 0; i < qty; i++) {
            // `Math.random() * (max - min)` returns a value in the range [0, max – min] where max is excluded.
            // `+min` shift this range up to the range that you are targeting
            // and casting to int finally coverts it to an integer
            int n = (int) ((Math.random() * (max - min)) + min);
            rnd.add(n);
        }
        return rnd;
    }

    /** range: [min,max)
     * This should be the method used in most cases
     * ref: https://www.javamex.com/tutorials/random_numbers/ThreadLocalRandom.shtml */
    public static List<Integer> threadLocalRandom(int min, int max, int qty) {
        Random rng = ThreadLocalRandom.current();
        return rng.ints(qty, min, max).boxed().collect(Collectors.toList());    // using stream
    }

    public static List<Integer> randomClass(int min, int max, int qty) {
        Random rng = new Random();
        return rng.ints(qty, min, max).boxed().collect(Collectors.toList());
    }

    /** This method generates a stream, and includes statistical corrections
     * https://www.javamex.com/tutorials/random_numbers/java_util_random.shtml */
    public static List<Integer> randomFromStream(int min, int max, int qty) {
        Random rng = new Random();
        return rng.ints(qty, min, max).boxed().collect(Collectors.toList());
    }

    public static List<Integer> predictablyRandom(int min, int max, int qty, int seed) {
        Random rng = new Random(seed);
        return rng.ints(qty, min, max).boxed().collect(Collectors.toList());
    }
}
/* ref:
 * [THOERY] https://www.random.org/randomness/
 * [BEST] https://www.javamex.com/tutorials/random_numbers/
 * https://www.javamex.com/tutorials/random_numbers/java_util_random.shtml
 * https://dzone.com/articles/random-number-generation-in-java
 * https://www.baeldung.com/java-generating-random-numbers
 * [JEP 356: Enhanced Pseudo-Random Number Generators] https://openjdk.java.net/jeps/356
 * https://machinelearningmastery.com/how-to-generate-random-numbers-in-python/
 */
