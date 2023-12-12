package org.abushl123.chapter1.enums;

public enum Season {
    // enum requires the list of values to be always declared first, even before the constructor
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium"); // <--- the semicolon is not required if enums contains ONLY values

    private final String expectedVisitors;

    private Season(String expectedVisitors) { // constructors are private implicitly and making it any other access modifier will cause compilation error
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}

class TestSeasons {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }

//        if (Season.SUMMER == 2) {} DOES NOT COMPILE

        Season s = Season.valueOf("SUMMER");

        // Season t = Season.valueOf("summer"); // throws an exception at runtime - IllegalArgumentException

        switch (s) {
            case WINTER:
                System.out.println("The out the sled!"); break;
            case SUMMER:
                System.out.println("Time for pool!"); break;
            default:
                System.out.println("Is it summer yet?"); break;
        }

        Season.SUMMER.printExpectedVisitors();
    }
}

//enum ExtendedSeasons extend Season { } // enums cannot be inherited

