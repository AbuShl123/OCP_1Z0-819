package ocp_1Z0_819.chapter5.localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.DecimalFormat;
import java.util.Locale;

public class NumberFormatting {
	static Locale RUSSIA = new Locale.Builder()
			.setLanguage("ru")
			.setRegion("RU").build();

	public static void main(String... args) throws ParseException {
		int number = 234999;

		NumberFormat us = NumberFormat.getInstance(Locale.US);
		NumberFormat gr = NumberFormat.getInstance(Locale.GERMANY);
		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		NumberFormat ru = NumberFormat.getInstance(RUSSIA);

		System.out.println(us.format(number));
		System.out.println(gr.format(number));
		System.out.println(ca.format(number));
		System.out.println(ru.format(number));

		// pricing
		double price = 48;
		NumberFormat usPricing = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(usPricing.format(price));

		NumberFormat ruPricing = NumberFormat.getCurrencyInstance(RUSSIA);
		System.out.println(ruPricing.format(price));

		// parsing
		String input = "$345897.90";
		double income = (Double) usPricing.parse(input);
		System.out.println(income);
		System.out.println(ruPricing.format(345_897.90));
		System.out.println(ruPricing.parse("345 897,90 ₽"));

		// DecimalFormat -- creating your own NumberFormat
		double n = 134_123.1453;

		DecimalFormat ruFormat = new DecimalFormat("### ###.###₽");

		System.out.println(ruFormat.format(n));
	}
}
