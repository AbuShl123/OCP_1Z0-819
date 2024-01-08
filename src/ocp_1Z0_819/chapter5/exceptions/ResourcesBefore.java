package ocp_1Z0_819.chapter5.exceptions;

public class ResourcesBefore {
	static class MyReader implements AutoCloseable {
		final String name;
		public MyReader(String name) {
			this.name = name;
		}

		@Override public void close() {
			System.out.println("Closing " + this.name);
		}
	}

	public static void main(String[] args) {
		MyReader reader = new MyReader("1");

		try (reader) {
			System.out.println("Working with reader");
		}
	}
}
