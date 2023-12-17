package ocp_1Z0_819.chapter2.applying_annotations;

@MyAnnotation()
@Apply(count = 12)
public class CrazyExamples {

	@Deprecated @MyAnnotation
	public CrazyExamples(@NotNull @Tasty int number) {}
	
	@Apply(count = 12) @Fast
	public static void main (String[] args) {
		@MyAnnotation(name = "This a local field") String fieldName = "Hello";
		
		IFunctionalInterface func = new IFunctionalInterface() {
			@Deprecated
			@MyAnnotation(name = "This a method")
			public void run(@NotNull Runnable statement) {
				statement = () -> {};
			}
		};

		@NotNull IFunctionalInterface lambdaOne = (@Fast() Runnable runner) -> System.out.println("Indeed fast");

		lambdaOne.run(() -> {});

		InnerOne innerOne = new InnerOne() {};
	}

	@Apply(count = 12)
	static abstract class InnerOne {

	}
}

@MyAnnotation
interface IFunctionalInterface {
	void run(Runnable run);
}

@interface MyAnnotation {
	String name() default "Name";
}

@interface Apply {
	int count();

}
@interface Tasty {


}
@interface Fast {


}
@interface NotNull {


}
