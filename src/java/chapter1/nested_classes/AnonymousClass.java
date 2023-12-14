package org.abushl123.chapter1.nested_classes;

public class AnonymousClass {
    interface Climb {};

    protected Climb climbImplementation = new Climb() {}; // <-- anonymous class
}

class ZooGiftShop {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() { return 3; }
        };

        return sale.dollarsOff();
    }

    public int admission(int basePrice, SaleTodayOnly only) {
        return basePrice - only.dollarsOff();
    }

    public int pay() {
        return admission(10, new SaleTodayOnly() { int dollarsOff() { return 3; } });
    }

    public void method() {
        System.out.println("Originally just text");
    }

    public void localSpace() {
        ZooGiftShop zooGiftShop = new ZooGiftShop() {
            public void method() { System.out.println("Overriden text"); }
        };

        zooGiftShop.method();
    }
}
