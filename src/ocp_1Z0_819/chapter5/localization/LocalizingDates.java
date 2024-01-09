package ocp_1Z0_819.chapter5.localization;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalizingDates {
    public static void main(String[] args) {

        LocalDateTime date = LocalDateTime.of(2005, Month.MARCH, 6, 14, 45, 20);

        Locale fuckingUS = Locale.US;
        Locale theRestOfTheWorld = new Locale.Builder().setLanguage("ru").setRegion("RU").build();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);

        System.out.println("DATE");
        System.out.println("America: " + dateFormatter.withLocale(fuckingUS).format(date));
        System.out.println("The rest of the world: " + dateFormatter.withLocale(theRestOfTheWorld).format(date));

        System.out.println();

        System.out.println("TIME");
        System.out.println("America: " + timeFormatter.withLocale(fuckingUS).format(date));
        System.out.println("The rest of the world: " + timeFormatter.withLocale(theRestOfTheWorld).format(date));

        System.out.println();

        System.out.println("DATE_TIME");
        System.out.println("America: " + dateTimeFormatter.withLocale(fuckingUS).format(date));
        System.out.println("The rest of the world: " + dateTimeFormatter.withLocale(theRestOfTheWorld).format(date));
    }
}
