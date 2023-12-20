package ocp_1Z0_819.chapter2.annotation_specific_annotations;

import java.lang.annotation.*;

public class TargetAnnotation {
	class OurSrc extends @Technical TargetAnnotation {
	}
	
	public void repair() {
		var repairSubclass = new @Technical TargetAnnotation() {};
		
		var o = new @Technical TargetAnnotation().new OurSrc();

		int num = (@Technical int) 10.0;
	}

}


@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@interface ZooAttraction {}

@Target(ElementType.TYPE_USE)
@interface Technical {}