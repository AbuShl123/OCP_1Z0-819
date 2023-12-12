package org.abushl123.chapter1.enums;

public enum OnlyOne {
    ONCE(true);

    OnlyOne(boolean b) {
        System.out.print("Constructing.");
    }
}

class PrintTheOne {
    public static void main(String[] args) {
        System.out.print("Begin ");
        OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print constructing again
        System.out.print(" end.");
    }
}
