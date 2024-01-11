package ocp_1Z0_819.chapter5.localization;

import java.util.Locale;
import java.text.NumberFormat;

public class LocalesCategory {
	static Locale RUSSIA = new Locale.Builder().setLanguage("ru").setRegion("RU").build();

	public static void main(String... args) {
		Locale.setDefault(RUSSIA);
		
		Locale spain = new Locale("es", "ES");
		
		System.out.println(spain.getDisplayLanguage());	

		Locale.setDefault(Locale.Category.DISPLAY, Locale.US); // we set display as English, but not formatting!
		System.out.println(spain.getDisplayLanguage());	
		
		double price = 500;
		System.out.println(NumberFormat.getCurrencyInstance().format(price)); // 500 rubles 

		Locale.setDefault(Locale.Category.FORMAT, spain);
		System.out.println(NumberFormat.getCurrencyInstance().format(price)); // now spanish formatting, but english display 
	}
}
