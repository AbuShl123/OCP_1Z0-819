package java.chapter1.nested_classes;

public class LocalClassExample {
    int length = 10;

    void calculate() {
        final int width = 20;
        class LocalClass {
            void multiply() {
                System.out.println(length * width);
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.multiply();
    }

    void errorMethod() {
        final int length = 5;
        int width = 10;
        int height = 2;
        class VolumeCalculator {
            public int multiply() {
//              return length * width * height; // DOES NOT COMPILE because of the line 28

                return 0;
            }
        }

        height = 3;
    }

    public static void main(String[] args) {
        LocalClassExample localClassExample = new LocalClassExample();

        localClassExample.calculate();
    }
}
