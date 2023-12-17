package ocp_1Z0_819.chapter1.interfaces;

public class DefaultExample {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("cat.getSpeed() = " + cat.getSpeed());
        System.out.println("cat.getWalkSpeed() = " + cat.getWalkSpeed());
        System.out.println("cat.getRunSpeed() = " + cat.getRunSpeed());
    }
}


class Cat implements Walk, Run {
    public int getSpeed() {
        return 20;
    }

    public int getWalkSpeed() {
        return Walk.super.getSpeed();
    }

    public int getRunSpeed() {
        return Run.super.getSpeed();
    }
}

interface Walk {

    default int getSpeed() {
        return 10;
    }
}

interface Run {
    default int getSpeed() {
        return 65;
    }
}
