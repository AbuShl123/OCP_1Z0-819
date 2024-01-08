package ocp_1Z0_819.chapter5.exceptions;

import java.io.*;
import java.util.*;

public class TryWithResources {
	static class ClosableObj implements AutoCloseable {
		public void close() {
			System.out.println("Closed resources");
		}
	}
	public static void main(String... args) {
		// try (String fileName = "ExceptionNotes.txt") {} COMPILE ERROR 

		try (var file = new FileInputStream("exceptionsNotes.txt")) {

		} catch (Exception e) {	e.printStackTrace(); }

		try (var resource = new ClosableObj()) {
			System.out.println("Try block");
		} finally {
			System.out.println("Finally Block");
		}
	}
}
