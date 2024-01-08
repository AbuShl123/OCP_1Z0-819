package ocp_1Z0_819.chapter5.exceptions;

import java.io.*;

public class SuppressedExceptions {
	static class BrokenReader implements AutoCloseable {
        String name;
        BrokenReader (String name) {
            this.name = name;
        }

		@Override public void close() {
			throw new IllegalStateException(name);
		}
	}

	public static void main(String[] args) {
		BrokenReader in1 = new BrokenReader("1");

		try (in1;
             var in2 = new BrokenReader("2");
             var in3 = new BrokenReader("3")) {

			throw new FileNotFoundException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
