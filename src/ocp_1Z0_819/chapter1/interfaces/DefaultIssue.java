package ocp_1Z0_819.chapter1.interfaces;

import java.io.IOException;

public class DefaultIssue implements Printer, Console {

    // since class inherits two interfaces with the same default methods, it must override this method

    public void print(String text) {
        System.out.println("Generic print: " + text);
    }

    // however, default finish() doesn't need to be overriden, since they have different method signatures

}

interface Printer {
    default void print(String text) throws IOException  {
        System.out.println("Printing text: {" + text + "} on paper");
    }

    default void finish() {
        System.out.println("Printer is off now");
    }
}

interface Console {
    default void print(String text) throws RuntimeException {
        System.out.println(text);
    }

    default void finish(int code) {
        System.out.println("Process finished with exit code " + code);
    }
}
