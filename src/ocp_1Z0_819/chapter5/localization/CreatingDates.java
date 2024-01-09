package ocp_1Z0_819.chapter5.localization;

import java.time.*;
public class CreatingDates {
	public static void main(String... args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
	}
}
