package com.alexstudy.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName NaturalNumber
 * @Description TODO()
 * @date 2018/7/27 17:31:46
 */
//public class NaturalNumber<T extends Integer> {
//    private T n;
//
//    public NaturalNumber(T n)  { this.n = n; }
//
//    public boolean isEven() {
//        return n.intValue() % 2 == 0;
//    }
//}

class NaturalNumber {

    private int i;

    public NaturalNumber(int i) { this.i = i; }
    // ...
    public static void main(String[] args){
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
       // ln.add(new NaturalNumber(35));  // compile-time error
    }
}

class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
    // ...
}