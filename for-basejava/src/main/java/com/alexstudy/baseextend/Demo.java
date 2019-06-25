package com.alexstudy.baseextend;

/**
 * @ClassName Demo
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/6/24
 */
public class Demo {
//    static double $rate;
//    static int numOfDollars;
//    static
//    {
//        $rate = 44.6;
//        numOfDollars = 12;
//        System.out.println("I am static block, I am called first.");
//    }
//    public static void main(String args[])
//    {
//        Demo d1 = new Demo();
//        System.out.println("I am main() method, executed after static block.");
//        System.out.println("Dollar value in Rupees: " + $rate * numOfDollars);
//    }

    double $rate;
    int numOfDollars;
    static Demo d1;
    static
    {
        d1 = new Demo();
        d1.$rate = 44.6;
        d1.numOfDollars = 12;
        System.out.println("I am static block, I am called first.");
    }
    public static void main(String args[])
    {
        System.out.println("I am main() method, executed after static block.");
        System.out.println("Dollar value in Rupees: " + d1.$rate * d1.numOfDollars);
    }
}
