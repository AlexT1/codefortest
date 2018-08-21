package com.alexstudy.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName MyClass
 * @Description TODO()
 * @date 2018/7/31 14:32:06
 */
public class MyClass<X> {
    <T>  MyClass(T t){
        System.out.println(t);
    }
//    public static void printList(List<Object> list) {
//        for (Object elem : list)
//            System.out.println(elem + " ");
//        System.out.println();
//    }
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
    public static void main(String[] args){
        MyClass<Integer>  myClass = new MyClass<Integer>("hello");
       System.out.println(Collections.emptyList());
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(li);
        System.out.println(li.size());
        System.out.println(ls.size());
        printList(ls);
        printList(null);
    }
}
