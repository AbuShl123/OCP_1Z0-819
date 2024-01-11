package ocp_1Z0_819.chapter5.localization;

import java.util.*;

public class ResourceBundleExample {
	static void printWelcomeMessage(Locale locale) {
		var rb = ResourceBundle.getBundle("Zoo", locale);
		System.out.println(rb.getString("hello") + ", " + rb.getString("open"));

        rb.keySet().stream().map(e -> e + ": " + rb.getString(e)).forEach(System.out::println);
	}

	public static void main(String[] args) {
		var us = new Locale("en", "US");
        var france = new Locale("fr", "FR");
        var russia = new Locale("ru", "RU");

		printWelcomeMessage(us);
		printWelcomeMessage(russia);
		printWelcomeMessage(france);

		var rusRb = ResourceBundle.getBundle("Zoo", russia);

		System.out.println(rusRb.getString("name"));
	}
}
