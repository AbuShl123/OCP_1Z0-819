package ocp_1Z0_819.chapter2.annotation_specific_annotations;

import java.lang.annotation.Repeatable;

public class RepeatableAnnotation {
    class Monkey {
    }

    @Risk(danger = "silly")
    @Risk(danger = "aggressive", level = 3)
    @Risk(danger = "violent", level = 10)
    private Monkey monkey;
}


@interface Risks {
    Risk[] value();
}

@Repeatable(Risks.class)
@interface Risk {
    String danger();
    int level() default 1;
}
