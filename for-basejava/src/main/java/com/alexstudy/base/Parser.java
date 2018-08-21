package com.alexstudy.base;

import java.io.File;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName Parser
 * @Description TODO()
 * @date 2018/8/16 15:23:33
 */
public class Parser<T extends Exception> {

    public <T extends Object & Comparable<? super T>> T findMax(List<T> lists, int begin, int end) {
        T max = lists.get(begin);
        for (int i=begin; i <= end; i++) {
            T temp =  lists.get(i+1);
            if (max.compareTo(temp) < 0) {
                max = temp;
            }
        }
        return max;
    }

    public void findMin(){

    }

    public void parse(File file) throws T {     // OK
        // ...
    }
    public void parsed(String string) throws T {     // OK
        // ...
        System.out.println(string);
        throw new RuntimeException();
    }
    public void callMethod() throws T {
        parsed("ddd");
    }
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        parser.callMethod();
    }
//    public static <T extends Exception, J> void execute(List<J> jobs) {
//        try {
//            for (J job : jobs) {
//
//            }
//            // ...
//        } catch (T e) {   // compile-time error
//            // ...
//        }
//    }
}
