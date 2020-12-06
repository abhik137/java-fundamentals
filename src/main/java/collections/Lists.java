package collections;

import utils.RandomIntegers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lists {
    private static List<Integer> list = null;

    /** ways to create list
     * ref: https://www.baeldung.com/java-init-list-one-line */
    private static void createList() {

    }

    private static void initList() {
        list = RandomIntegers.predictablyRandom(0, 99, 10, 13);
        Collections.shuffle(list);
    }

    private static Comparator<Integer> getIntegerComparator() {

        // Anonymous Comparator Class
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // Utilizing Functional Interface property and static factory methods of Comparator.java

        cmp = Comparator.comparingInt(i -> i);
        cmp = Integer::compare;
        cmp = Integer::compareTo;
        return cmp;
    }

    private static void sortList(Comparator<Integer> cmp) {
        // old fashioned way
        Collections.sort(list, cmp);

        /* new way */
        // list.sort(cmp);
        // list.sort((i, j) -> Integer.compare(i, j));
        // list.sort(Comparator.comparingInt(i -> i));
        // list.sort(Integer::compare);
    }

    private static void sortListReversed(Comparator<Integer> cmp) {
        list.sort(cmp.reversed());
    }

    private static void subList() {
        List<Integer> subList = list.subList(2, 5);
        System.out.println(subList);
        subList.clear();    // modifies the original list
        System.out.println(subList);
        System.out.println(list);
        subList.add(99);
        subList.add(98);
        subList.add(97);
        System.out.println(subList);
        System.out.println(list);
        Collections.shuffle(subList);
        System.out.println(subList);
        System.out.println(list);

        list.add(99);
        System.out.println(list.indexOf(23));
        System.out.println(list.lastIndexOf(99));
    }

    public static void main(String[] args) {
        initList();

        Comparator<Integer> cmp = getIntegerComparator();

        sortList(cmp);
        System.out.println(list);
        subList();
    }
}
