package ocp_1Z0_819.chapter4.streams.advances_stream_flow;

import java.util.*;
import java.util.stream.*;
public class RefactorUnderlyingData {
	public static void main(String[] args) {
		List<String> animals = new ArrayList<>(List.of("Panda", "Insect"));

		var stream = animals.stream();

		animals.add("Bear");

		System.out.println(stream.count()); // 3
	}
}

