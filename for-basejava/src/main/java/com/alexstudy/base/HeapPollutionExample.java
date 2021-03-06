package com.alexstudy.base;

import org.apache.commons.math.MathException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName HeapPollutionExample
 * @Description TODO()
 * @date 2018/8/14 15:59:06
 */

public class HeapPollutionExample {

    //Warning:(29, 31) java: 对于类型为java.util.List<java.lang.String>[]的 varargs 参数, 泛型数组创建未经过检查
    //Warning:(32, 34) java: 对于类型为java.util.List<java.lang.String>[]的 varargs 参数, 泛型数组创建未经过检查
    //When compiled, the following warning is produced by the definition of the ArrayBuilder.addToList method:
    //warning: [varargs] Possible heap pollution from parameterized vararg type T
//    public static void main(String[] args) {
//
//        List<String> stringListA = new ArrayList<String>();
//        List<String> stringListB = new ArrayList<String>();
//
//        ArrayBuilder.addToList(stringListA, "Seven", "Eight", "Nine");
//        ArrayBuilder.addToList(stringListB, "Ten", "Eleven", "Twelve");
//        List<List<String>> listOfStringLists =
//                new ArrayList<List<String>>();
//        ArrayBuilder.addToList(listOfStringLists,
//                stringListA, stringListB);
//
//        ArrayBuilder.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
//    }

    public static <E> void append(List<E> list, Class<E> cls) throws Exception {

//        E elem = new E();  // compile-time error
//        list.add(elem);

        E elem = cls.newInstance();   // OK
        list.add(elem);
    }
 //   @SuppressWarnings("unchecked")
// @SuppressWarnings({"unchecked", "varargs"}) // above class is not work, at here worked,must on method
    public static void main(String[] args) {

        Object[] strings = new String[2];
        strings[0] = "hi";   // OK
        strings[1] = 100;    // An ArrayStoreException is thrown.

        List<String> ls = new ArrayList<>();
        try {
            append(ls, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
