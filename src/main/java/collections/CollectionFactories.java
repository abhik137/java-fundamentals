package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class CollectionFactories {
    public static void main(String[] args) {
        // Collections.unmodifiableList();
        // Collections.unmodifiableMap();
        // Map.copyOf();
        // Map.of();

        // Alternative to mutable List.of() / Arrays.asList;
        var aList = new ArrayList<Integer>();   // an empty list
        Collections.addAll(aList, 1, 2, 3);
        System.out.println(aList);

        Collections.shuffle(aList);
        System.out.println(aList);

        Collections.fill(aList, -1);
        System.out.println(aList);
    }
}
