package com.alexstudy.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName BoxDemo
 * @Description TODO()
 * @date 2018/7/31 11:05:36
 */
public class BoxDemo {

    public static <U> void addBox(U u,
                                  java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    // upper bounded wildcards
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

    //Lower Bounded Wildcards
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        //Warning:(47, 43) java: 未经检查的转换
        //需要: java.util.Map<java.lang.String,java.util.List<java.lang.String>>
        //找到: java.util.HashMap
//        Map<String, List<String>> myMap = new HashMap(); // unchecked conversion warning
        // Unchecked assignment: 'java.util.HashMap' to 'java.util.Map<java.lang.String,java.util.List<java.lang.String>>' less... (Ctrl+F1)

        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
                new java.util.ArrayList<>();
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }
}
