package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName BicycleDemo
 * @Description TODO()
 * @date 2018/8/24 16:38:24
 */
public class BicycleDemo {
    public static void main(String[] args) {
        int num = 5_1;
        int x3 = 5_______2;
        int x6 = 0x5_2;
        System.out.println(num +  "   " + x3 + " " + x6);
        // Create two different
        // Bicycle objects
        Bicycle bike1 = new Bicycle();
        Bicycle bike2 = new Bicycle();

        // Invoke methods on
        // those objects
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();

        bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        bike2.printStates();
    }
}
