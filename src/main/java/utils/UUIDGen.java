package utils;

import java.util.UUID;

public class UUIDGen {
    public static String getUUID() {
        UUID uniqKey = UUID.randomUUID();
        // System.out.println(uniqKey.variant());
        // System.out.println(uniqKey.version());
        System.out.println(uniqKey.getMostSignificantBits());
        System.out.println(uniqKey.getLeastSignificantBits());
        // System.out.println(uniqKey.timestamp());
        // System.out.println(uniqKey.clockSequence());
        return uniqKey.toString();
    }

    public static void main(String[] args) {
        System.out.println(getUUID());  // 36-char string (4 hyphens + 32 hexadecimal(128-bits))
    }
}
/* ref:
 * https://www.uuidgenerator.net/
 * https://en.wikipedia.org/wiki/Universally_unique_identifier
 * https://www.ietf.org/rfc/rfc4122.txt
 * To Read:
 * https://www.baeldung.com/java-uuid
 * https://crunchify.com/uuid-uid-random-or-messagedigest-number-of-ways-to-create-unique-idkey-in-java/
 * https://www.callicoder.com/distributed-unique-id-sequence-number-generator/
 * https://docs.python.org/3/library/uuid.html
 */
