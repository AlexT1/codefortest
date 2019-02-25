package com.alexstudy.base;

import java.util.Locale;

/**
 * @author AlexTong
 * @ClassName BicycleDemo
 * @Description TODO()
 * @date 2018/8/24 16:38:24
 */
public class BicycleDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        String fs;
        fs = String.format("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        " and the string is %s",
                3.455, 3, "world!");
        System.out.println(fs);
        String quote =
                "Now is the time for all good " +
                        "men to come to the aid of their country.";
        System.out.println(quote);
        System.out.format(Locale.FRANCE,
                "The value of the float " + "variable is %f, while the " +
                        "value of the integer variable " + "is %d, and the string is %s%n",
                3.455, 3, "hello");
        System.out.format(Locale.ENGLISH,"The value of " + "the float variable is " +
                "%f, while the value of the " + "integer variable is %d, " +
                "and the string is %s", 3.455, 3, "hello");
        System.out.println();
        System.out.println(Integer.decode("0xFFFF"));
        System.out.println(Integer.parseInt("00110",16));
        System.out.println(Integer.valueOf("333",8));
        int num = 5_1;
        int x3 = 5_______2;
        int x6 = 0x5_2;

        System.out.println(num +  "   " + x3 + " " + x6);
        // Create two different
        // Bicycle objects
        Bicycle bike1 = new Bicycle(1,1,1);
        Bicycle bike2 = new Bicycle(2,3,3);
        Bicycle bike3 = bike1.returnCloneObject(bike1);
        bike3.printDescription();
        System.out.println(bike3.cadence);
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
