package utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Attempting to Generate <unique> </unique>random strings, similar to NanoIds etc
 * using a CSPRNG(cryptographically secure PRNG)
 */
public final class UniqueRandomStringGenerator {

    /**
     * <code>UniqueRandomStringGenerator</code> instances should NOT be constructed in standard programming.
     * Instead, the class should be used as <code>UniqueRandomStringGenerator.randomNanoId();</code>.
     */
    private UniqueRandomStringGenerator() {
        //Do Nothing
    }

    /**
     * The default random number generator used by this class.
     * Creates cryptographically strong NanoId Strings.
     */
    public static final SecureRandom DEFAULT_NUMBER_GENERATOR = new SecureRandom();

    /**
     * The default alphabet used by this class.
     * Creates url-friendly NanoId Strings using 64 unique symbols.
     */
    public static final char[] DEFAULT_ALPHABET =
            "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * The default size used by this class.
     * Creates NanoId Strings with slightly more unique values than UUID v4.
     */
    public static final int DEFAULT_SIZE = 21;

    /**
     * Static factory to retrieve a url-friendly, pseudo randomly generated, NanoId String.
     *
     * The generated NanoId String will have 21 symbols.
     *
     * The NanoId String is generated using a cryptographically strong pseudo random number
     * generator.
     *
     * @return A randomly generated NanoId String.
     */
    public static String randomNanoId() {
        return randomNanoId(DEFAULT_NUMBER_GENERATOR, DEFAULT_ALPHABET, DEFAULT_SIZE);
    }

    /**
     * Static factory to retrieve a NanoId String.
     *
     * The string is generated using the given random number generator.
     *
     * @param random   The random number generator.
     * @param alphabet The symbols used in the NanoId String.
     * @param size     The number of symbols in the NanoId String.
     * @return A randomly generated NanoId String.
     */
    public static String randomNanoId(final Random random, final char[] alphabet, final int size) {

        if (random == null) {
            throw new IllegalArgumentException("random cannot be null.");
        }

        if (alphabet == null) {
            throw new IllegalArgumentException("alphabet cannot be null.");
        }

        if (alphabet.length == 0 || alphabet.length >= 256) {
            throw new IllegalArgumentException("alphabet must contain between 1 and 255 symbols.");
        }

        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than zero.");
        }

        final int mask = (2 << (int) Math.floor(Math.log(alphabet.length - 1) / Math.log(2))) - 1;
        final int step = (int) Math.ceil(1.6 * mask * size / alphabet.length);

        final StringBuilder idBuilder = new StringBuilder(size);

        while (true) {

            final byte[] bytes = new byte[step];
            random.nextBytes(bytes);

            for (int i = 0; i < step; i++) {

                final int alphabetIndex = bytes[i] & mask;

                if (alphabetIndex < alphabet.length) {
                    idBuilder.append(alphabet[alphabetIndex]);
                    if (idBuilder.length() == size) {
                        return idBuilder.toString();
                    }
                }

            }

        }

    }

    public static void main(String[] args) {

        String randomNanoId = UniqueRandomStringGenerator.randomNanoId(new SecureRandom(),
                "_-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(), 10);
        System.out.println(randomNanoId);

        // randomNanoId = UniqueRandomStringGenerator.randomNanoId();
        // System.out.println(randomNanoId);
    }
}
/* ref:
 * https://www.baeldung.com/java-secure-random
 * https://github.com/aventrix/jnanoid
 * https://stackoverflow.com/questions/12726434/use-of-sha1prng-in-securerandom-class
 * https://stackoverflow.com/questions/27622625/securerandom-with-nativeprng-vs-sha1prng/27638413#27638413
 */