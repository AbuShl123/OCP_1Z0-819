package ocp_1Z0_819.chapter2.annotation_specific_annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@notation
public class TargetTest<T> {
    @notation
    TargetTest<Integer> targetTest = new TargetTest<>();

    public static void main(String[] args) {

    }

    public void method(@notation int number) {
        String name = new @notation String("hi");

        Integer a = (@notation Integer) number;

        Addable add = (@notation int n) -> n+1;


    }

    interface Addable {
        int add(int num);
    }
}

@Target(ElementType.TYPE_USE)
@interface notation {

}