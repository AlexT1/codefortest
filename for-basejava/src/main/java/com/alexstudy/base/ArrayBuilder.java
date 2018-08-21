package com.alexstudy.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName ArrayBuilder
 * @Description TODO()
 * @date 2018/8/14 15:34:55
 */

public class ArrayBuilder {

    public static <T> void addToList (List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }

   // @SafeVarargs
   //@SuppressWarnings({"unchecked", "varargs"})
    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }

}