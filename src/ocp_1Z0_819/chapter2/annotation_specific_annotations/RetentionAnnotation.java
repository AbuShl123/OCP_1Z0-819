package ocp_1Z0_819.chapter2.annotation_specific_annotations;

import java.lang.annotation.*;

public class RetentionAnnotation {

}


@Retention(RetentionPolicy.CLASS) @interface Flier {}
@Retention(RetentionPolicy.RUNTIME) @interface Swimmer {}