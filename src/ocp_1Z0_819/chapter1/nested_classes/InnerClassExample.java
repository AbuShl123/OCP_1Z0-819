package ocp_1Z0_819.chapter1.nested_classes;

public class InnerClassExample {

}

class Fox {
    private class Den {}
    public void goHome() {
        new Den();
    }

    public static void visitFriend() {
        // new Den(); // Does not compile
        new Fox().new Den(); // compiles
    }
}

class Squirrel {
    public void visitFox() {
        // new Den(); // Does not compile
        // new Fox().new Den(); // Does not compile either, because Den is a private class
    }
}

class Outer {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.print(greeting);
            }
        }

//      public static void statiMethod() {} // static methods are not allowed here

//      static String inners; // static fields are not allowed here

        static final String KEY = "INNER_"; // but for some reason this one is allowed...
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();

        Inner inner = outer.new Inner(); // create the inner class
        inner.go();
    }
}

