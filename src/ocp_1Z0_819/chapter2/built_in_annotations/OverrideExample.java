package ocp_1Z0_819.chapter2.built_in_annotations;


public class OverrideExample {
	
	static String name = "Override example";
	
	@Override
	public String toString() {
		return name;
	}


	public static void main(String... args) {
		OverrideExample o = new OverrideExample();
		
		System.out.println(o.toString());
	}
}

