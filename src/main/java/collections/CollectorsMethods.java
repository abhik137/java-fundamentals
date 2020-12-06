package collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsMethods {

    public static void createList() {
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,6);

        List<Integer> collectorList = integers.stream().map(x -> x * x).collect(Collectors.toList());

        System.out.println(collectorList);
    }

    public static void main(String[] args) {
        createList();
    }
}
