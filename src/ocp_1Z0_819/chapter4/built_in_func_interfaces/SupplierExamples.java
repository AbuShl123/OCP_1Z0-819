package ocp_1Z0_819.chapter4.built_in_func_interfaces;

import java.util.function.*;
import java.util.ArrayList;

public class SupplierExamples {
	public static void main(String[] args) {
		Supplier<StringBuilder> getSb = StringBuilder::new; 

		StringBuilder sb = getSb.get();
		sb.append("Hello Earth");
		System.out.println(sb);
		System.out.println(getSb); // path/to/SupplerExamples$$...		$$ means that it's in memory

		Supplier<ArrayList<String>> getList = ArrayList::new;

		var list = getList.get();
		list.add("Groceries");
		System.out.println(list);
	}
}
