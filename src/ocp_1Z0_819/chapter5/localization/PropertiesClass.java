package ocp_1Z0_819.chapter5.localization;

import java.util.Properties; 

public class PropertiesClass {
	public static void main(String ... args) {
		Properties props = new Properties();

		props.setProperty("name", "Our Zoo");
		props.setProperty("open.time", "8am");

		System.out.println(props.get("open.time"));
		System.out.println(props.getProperty("name", "The Zoo"));
		System.out.println(props.getProperty("close.time", "12am"));
	}
}
