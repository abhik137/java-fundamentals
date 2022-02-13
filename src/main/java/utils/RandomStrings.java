package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

/** Generate random strings, note that it may not be <unique> */
public class RandomStrings {
    public static void simpleRandomBytesString(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        String generatedStr = new String(array, StandardCharsets.UTF_8);

        System.out.println(generatedStr);   // some garbage string
    }

    public static void simpleBoundedRandomAlphabeticString(int length) {
        int leftLimit = 97;  // letter 'a'
        int rightLimit = 122;  // letter 'z'
        Random rng = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int) (rng.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        String generatedString = buffer.toString();
        System.out.println(generatedString);
    }

    public static void simpleBoundedRandomAlphabeticStringJava8(int length) {
        int leftLimit = 97;  // letter 'a'
        int rightLimit = 122;  // letter 'z'
        Random rng = new Random();

        String generatedString = rng.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
    }

    public static void simpleBoundedRandomAlphaNumericStringJava8(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        // Random rng = ThreadLocalRandom.current();   // using a better RNG

        RandomGenerator rng = RandomGenerator.of("L32X64MixRandom");    // modern PRNG from Java17


        String generatedString = rng.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
    }

    public static void apacheRandomAlphaNumericString(int length) {
        String generatedString = RandomStringUtils.random(length);
        System.out.println(generatedString);    // all possible unicode characters

        generatedString = RandomStringUtils.random(length, true, false);
        System.out.println(generatedString);

        generatedString = RandomStringUtils.random(length, false, true);
        System.out.println(generatedString);

        generatedString = RandomStringUtils.randomAlphabetic(length);
        System.out.println(generatedString);

        generatedString = RandomStringUtils.randomNumeric(length);
        System.out.println(generatedString);

        generatedString = RandomStringUtils.randomAlphanumeric(length);
        System.out.println(generatedString);

        generatedString = RandomStringUtils.random(length, "0123456789abcdef");
        System.out.println(generatedString);
    }

    public static void main(String[] args) {
        apacheRandomAlphaNumericString(12);
        System.out.println("------------");
        simpleBoundedRandomAlphaNumericStringJava8(10);
        simpleBoundedRandomAlphabeticStringJava8(10);
        simpleBoundedRandomAlphabeticString(10);
        // simpleRandomBytesString(8);
    }
}
/* ref:
 * https://www.baeldung.com/java-random-string
 * https://stackoverflow.com/questions/4267475/generating-8-character-only-uuids#answer-45055701
 * https://user.commons.apache.narkive.com/GVBG2Ar0/commons-lang3-too-early-to-deprecate-randomstringutils-in-favor-of-randomstringgenerator
 * https://stackoverflow.com/questions/44947976/randomstringgenerator-to-generate-alphanumeric-strings/44948117
 * https://kodejava.org/how-do-i-generate-random-alphanumeric-strings/
 * https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/RandomStringGenerator.html
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/random/package-summary.html
 * https://en.wikipedia.org/wiki/Birthday_problem
 * https://math.stackexchange.com/questions/889538/probability-of-collision-with-randomly-generated-id
 */
