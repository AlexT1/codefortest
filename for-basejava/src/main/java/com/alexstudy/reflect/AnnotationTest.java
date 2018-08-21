package com.alexstudy.reflect;

import java.util.ArrayList;

/**
 * @author AlexTong
 * @ClassName AnnotationTest
 * @Description TODO()
 * @date 2018/7/3 17:10:16
 */
class Apple {
  //  private static long counter;
//    private final long id = counter++;
//    public long id() {
//        return id;
//    }
    private String numer;
    private String word;

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
class Orange{}

public class AnnotationTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
//        ArrayList apples = new ArrayList();
//        for(int i = 0; i < 3; i++) {
//           apples.add(new Apple());
//            //apples.add("");
//        }
//        apples.add(new Orange());
//        for(int j= 0; j < apples.size(); j++)
//          ((Apple) apples.get(j)).id();

    }

}

