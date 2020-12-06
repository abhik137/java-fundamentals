package classes;

public class StaticClass {
    /**
     * When to make nested class 'static'?
     * A static nested class cannot use instance variables of its parent class.
     * If it wants to, it'll have to instantiate the parent class first.
     * So, if you want to use variables/methods from parent class (and parent class is not static)
     * Then DON'T make inner/nested class static.
     * We don't need to use parent class members here, so we can use static.
     * Using static inner classes results in some minor savings of memory (see Sedgewick book)
     * NOTE: there's nothing 'static' about static classes in Java. They are just like normal classes
     * having static scope and unable to access non-static members
     * https://stackoverflow.com/questions/7486012/static-classes-in-java#7486050
     */
    private static class Node {
        /*
         * Note that for private nested classes, access modifiers for its members are irrelevant
         * Since `Node` is already private, no other class outside of SLList can use it anyway.
         * So private access modifiers here are useless, as the parent class SLList can use it if it wants
         * (access modifiers of nested class member doesn't matter to parent class) while no other class can,
         * but here we just keep it for consistency
         */
        private int item;
        private Node next;

        private Node(int x, Node n) {
            this.item = x;
            this.next = n;
        }
    }

    // TODO: use Node in class and testclient
}
/* ref:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/whentouse.html
 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 * https://stackoverflow.com/questions/7486012/static-classes-in-java#7486050
 */