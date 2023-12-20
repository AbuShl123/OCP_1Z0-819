package ocp_1Z0_819.chapter2.applying_annotations;

public class DefaultValue {
    @Injured("Broken Tail") public static class Monkey {}

    @Injured(veterinarian = "Mr. Johns", value = "Broken lap")
    public static class Cat {}
}

@interface Injured {
    String veterinarian() default "unassigned";
    String value() default "foot";
    int age() default 1;
}
