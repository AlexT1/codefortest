package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName ErasureGenericMethod
 * @Description TODO()
 * @date 2018/8/13 14:53:18
 */
public class ErasureGenericMethod {
    // Counts the number of occurrences of elem in anArray.
    public static <T> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }

//    Because T is unbounded, the Java compiler replaces it with Object:
//    public static int count(Object[] anArray, Object elem) {
//        int cnt = 0;
//        for (Object e : anArray)
//            if (e.equals(elem))
//                ++cnt;
//        return cnt;
//    }

    //Suppose the following classes are defined:
    class Shape { /* ... */ }
    class Circle extends Shape { /* ... */ }
    class Rectangle extends Shape { /* ... */ }
    //You can write a generic method to draw different shapes:

    public static <T extends Shape> void draw(T shape) { /* ... */ }
   // The Java compiler replaces T with Shape:
//    public static void draw(Shape shape) { /* ... */ }

}
