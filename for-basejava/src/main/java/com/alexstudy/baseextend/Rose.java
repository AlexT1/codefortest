package com.alexstudy.baseextend;

/**
 * @ClassName AbstractTest
 * @Description
 * @Author AlexTong
 * @Date 2019/6/13
 */
interface Flower {
    default void printf() {System.out.println("test default value");}
    void smell();
    static void printf(String s) {System.out.println("test default value" + s);}
}

public class Rose implements Flower {
    public void printf() {System.out.println("test default value 2");}
    public void smell() {
        System.out.println("Rose gives rosy smell");
    }
    private void printf(String s) {System.out.println("test default value 2" + s);}

    public static void main(String[] args) {
        Flower f;
        Rose r = new Rose();

        r.printf("test");
        r.smell();		                   // II

        f = r;                                // subclass object to super class reference variable
        f.smell();		                   // II

        // r  = f;                               // super class to subclass, not valid
        r = (Rose) f;	                   // explicit casting
        f.smell();		                   // II
    }
}