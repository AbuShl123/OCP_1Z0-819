package ocp_1Z0_819.chapter5.localization;

import java.text.*;

public class MessageFormatting {
	public static void main(String... args) {
		String msg = "Hello {0} and {1}";

		String formatted = MessageFormat.format(msg, "Henry", "Tommy");

		System.out.println(formatted);
	}	
}
