package com.alexstudy.base;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author AlexTong
 * @ClassName Box
 * @Description TODO()
 * @date 2018/7/27 17:15:50
 */
public class Box<T> {
    //To declare a bounded type parameter, list the type parameter's name, followed by the extends keyword,
    // followed by its upper bound, which in this example is Number. Note that, in this context, extends is
    // used in a general sense to mean either "extends" (as in classes) or "implements" (as in interfaces).
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
    public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
    //        if (e > elem)  // compiler error, it does not compile because the greater than operator (>)
                // applies only to primitive types such as short, int, double, long, float, byte, and char.
                // You cannot use the > operator to compare objects. To fix the problem, use a type parameter
                // bounded by the Comparable<T> interface
                ++count;
        return count;
    }
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }
    static <T> T pick(T a1, T a2) { return a2; }
    public static void main(String[] args) throws InterruptedException {
        Serializable s = pick("d", new ArrayList<String>());
//        Box<Integer> integerBox = new Box<Integer>();
//        integerBox.set(new Integer(10));
//        integerBox.inspect("some text"); // error: this is still String!
        Box<Integer> integerBox = new Box<Integer>();
        try {
            integerBox.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
