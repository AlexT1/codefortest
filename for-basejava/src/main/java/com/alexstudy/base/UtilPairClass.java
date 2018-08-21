package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName UtilPairClass
 * @Description TODO()
 * @date 2018/7/27 16:16:41
 */
public class UtilPairClass {
    public static <K, V> boolean compare(PairClass<K, V> p1, PairClass<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}
