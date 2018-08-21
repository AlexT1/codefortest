package com.alexstudy.base;

import java.util.Map;
import java.util.Set;

/**
 * @author AlexTong
 * @ClassName Example
 * @Description TODO()
 * @date 2018/8/16 15:59:54
 */
public class Example {
    public void print(Set<String> strSet) { }
//    public void print(Set<Integer> intSet) { }
    public void print(Map<Integer,String> intSet) { } // is ok

}
//public
//final class Algorithm {
//    public static <T> T max(T x, T y) {
//       return x > y ? x : y;  //compile error
//    }
//}