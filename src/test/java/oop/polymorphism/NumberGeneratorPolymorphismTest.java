package oop.polymorphism;

public class NumberGeneratorPolymorphismTest {
    public static void testPolymorphism() {
        BaseNumberGenerator generator = new MagicNumberGenerator(10);

        // TODO: guess the output
        System.out.println(generator.generate());
    }

    public static void main(String[] args) {
        testPolymorphism();
    }
}
