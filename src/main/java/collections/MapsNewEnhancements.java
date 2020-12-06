package collections;

import java.util.HashMap;
import java.util.Map;

/** Enhancements in Maps API since Java 8 */
public class MapsNewEnhancements {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        m.put(4, "d");

        /*----- getOrDefault -----*/
        System.out.println(m.get(5));   // returns null if not found
        System.out.println(m.getOrDefault(5, "x")); // return x as default val

        /*----- replace -----*/
        m.replace(1, "A");
        System.out.println(m);

        m.replace(5, "e");  // No change as key doesn't exist
        System.out.println(m);

        /*----- replaceAll -----*/
        // BiFunction takes 2 Inputs and gives 1 output
        // Here the function(lambda) replaces old value with new UpperCase value
        m.replaceAll((k, v) -> v.toUpperCase());
        System.out.println(m);

        /*----- computeIfAbsent -----*/
        // Unlike getOrDefault(), computeIfAbsent() uses a mapping function to
        // create a new value and INSERTS it into the map (only if it's missing)
        // the mapping function is called only if the mapping is not already present (or is mapped to null)
        m.computeIfAbsent(5, k -> Character.toString((char) 65 + k -1));
        System.out.println(m);

        /*----- forEach -----*/
        // BiConsumer takes 2 args in Input and returns nothing
        // This is equivalent to looping over entrySet
        m.forEach((k, v) -> System.out.println(k + "\t" + v));

        /*----- putIfAbsent -----*/
        m.putIfAbsent(5, "J");
        m.putIfAbsent(6, "J");
        System.out.println(m);

        /*----- computeIfPresent -----*/
        m.computeIfPresent(6, (k, v) -> Character.toString((char) 65 + k -1));
        System.out.println(m);

        /*----- compute -----*/

        /*----- merge -----*/

        /*----- create an unmodifiable entry/pair -----*/
        var entry = Map.entry(7, "G");
        System.out.println(entry);

        /*----- map from entry pairs -----*/
        var map2 = Map.ofEntries(Map.entry(1, "a"));
        System.out.println(map2);
    }
}
/* ref:
 * https://www.baeldung.com/java-map-computeifabsent
 * https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
 * https://stackoverflow.com/questions/17984975/convert-int-to-char-in-java
 * https://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string
 */
