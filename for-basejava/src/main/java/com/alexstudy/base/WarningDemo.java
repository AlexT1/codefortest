package com.alexstudy.base;

import java.util.Collections;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName WarningDemo
 * @Description TODO()
 * @date 2018/7/27 14:38:36
 */
@SuppressWarnings("unchecked") // suppresses unchecked warnings
public class WarningDemo {
    //As mentioned previously, when mixing legacy code with generic code, you may encounter warning messages similar to the following:
    //Note: Example.java uses unchecked or unsafe operations.
    //Note: Recompile with -Xlint:unchecked for details.

    public static void main(String[] args){
        GenericTest<Integer> bi;
        bi = createBox();
        WarningDemo warningDemo = new WarningDemo();
        warningDemo.processStringList(Collections.emptyList());
    }

    void  processStringList(List<String> stringList) {
        // process stringList
        System.out.println(stringList.getClass().toString());
    }

    static  GenericTest createBox(){
        return new  GenericTest();
    }

//    public static void main(String[] args){
//        Box<Integer> bi;
//        bi = createBox();
//    }
//
//    static Box createBox(){
//        return new Box();
//    }
}
