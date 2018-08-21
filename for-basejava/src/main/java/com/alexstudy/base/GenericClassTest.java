package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName GenericClassTest
 * @Description TODO()
 * @date 2018/7/26 18:01:28
 */
public class GenericClassTest {
    public static void main(String[] args){
        //You can also substitute a type parameter (i.e., K or V) with a parameterized type (i.e., List<String>). For example, using the OrderedPair<K, V> example:
        //OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");

    }
}
