package ocp_1Z0_819.chapter5.localization;

import java.util.*;

public class BasicLocales {
	public static void main(String[] args) {
		// default value
		Locale locale = Locale.getDefault();
		System.out.println(locale);

		// getting from constants 
		System.out.println(Locale.GERMAN); // lang
		System.out.println(Locale.GERMANY); // lang_COUNTRY

		// creating
		Locale myLocale = new Locale("tj", "TJ");
		System.out.println(myLocale);

		// builder pattern
		Locale l1 = new Locale.Builder()
					.setLanguage("ps")
					.setRegion("IR")
					.build();

		System.out.println(l1);

		// setting default 
		Locale.setDefault(l1);
		System.out.println(Locale.getDefault());
	}
}
