package ocp_1Z0_819.chapter3.sorting_data;

import java.util.*;

public class Human implements Comparable<Human> {

    private float height;

    public Human(float height) {
        this.height = height;
    }

    @Override
    public int compareTo(Human human) {
        int result = (int) (this.height - human.height); // alternatively: Double.compare(height, human.height);

        if (result > 0) {
            System.out.println("Ha, I am higher than you!");
        } else if (result < 0) {
            System.out.println("Nah, that's not possible.... but you are higher than me.");
        } else {
            System.out.println("We are on the same level?");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Abu prints his height: ");
        float abu = in.nextFloat();
        System.out.print("Your height: ");
        float anyOther = in.nextFloat();

        Human me = new Human(abu);
        Human classmate = new Human(anyOther);

        System.out.println(me.compareTo(classmate));
    }
}
