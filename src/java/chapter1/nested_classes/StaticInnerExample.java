package org.abushl123.chapter1.nested_classes;

public class StaticInnerExample {
    public static void main(String[] args) {
        Enclosing.Nested nested = new Enclosing.Nested();
    }
}

class Enclosing {
    static class Nested {
        private int price = 6;
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}

// if we were to import a nested static class two ways are acceptable:
// import org.abushl123.chapter1.nested_classes.Enclosing.Nested;
// import static org.abushl123.chapter1.nested_classes.Enclosing.Nested;

