package ocp_1Z0_819.chapter2.annotation_specific_annotations;

public class Inherited {

}


@java.lang.annotation.Inherited
@interface Vertebrate {}


@Vertebrate
class Mammal {}

class Dolphin extends Mammal {} // since Dolphin is extending Mammal and @Vertebrate is marked @Inherited, the @Vertebrate applis to Dolphin as well

