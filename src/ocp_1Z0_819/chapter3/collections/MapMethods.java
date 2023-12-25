package ocp_1Z0_819.chapter3.collections;

import ocp_1Z0_819.utils.JavaUtils;

import java.util.*;
import static ocp_1Z0_819.utils.JavaUtils.*;

public class MapMethods {

	public static void main(String... args) {
		Map<String, String> map = new HashMap<>();

		map.put("koala", "bamboo");
		map.put("monkey", "banana");

		Set<String> mapKeys = map.keySet();

		for (String key : mapKeys) println(key);

		println(map.containsKey("koala"));

		println(map.containsValue("banana"));

		Collection<String> values = map.values();

		values.forEach(JavaUtils::println);

		Set<Map.Entry<String, String>> entrySet = map.entrySet();

		entrySet.forEach(e -> printf("%s=%s, ", e.getKey(), e.getValue())); println();

		println(map.getOrDefault("cow", "grass"));

		map.replace("koala", "fruit");

		map.forEach((k, v) -> printf("%s=%s, ", k, v)); println();

		map.replaceAll((k, v) -> {return v + " or nature food";});

		map.forEach((k, v) -> printf("%s=%s, ", k, v));
	}

}