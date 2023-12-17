package ocp_1Z0_819.chapter2.introducing_annotations;

public @interface ExerciseAdvanced {
    int hoursPerDay();
    int startHour() default 6;
}
