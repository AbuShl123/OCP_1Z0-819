package ocp_1Z0_819.chapter5.exceptions;

import java.text.ParseException;

public class CloseExample {
    static class MyResource implements AutoCloseable {
        @Override public void close() throws ParseException {
            throw new ParseException("what happened", 3);
        }
    }

    public static void main(String[] args) {

        try (var resrc = new MyResource()) {

        } catch (ParseException e) { // since close() declares exception, catch is required
            System.out.println("Caught");
        }
    }
}
