package com.alexstudy.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExercisesTestDemo
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/11 16:16:05
 */
public class ExercisesTestDemo {
    public static void main(String[] args) {
        String[] students = new String[10];
        String studentName = "Peter Smith";
        students[0] = studentName;
        studentName = null;
        ExercisesDeck deck = new ExercisesDeck();
        for (int suit = ExercisesCard.DIAMONDS; suit <= ExercisesCard.SPADES; suit++) {
            for (int rank = ExercisesCard.ACE; rank <= ExercisesCard.KING; rank++) {
                ExercisesCard card = deck.getCard(suit, rank);
                System.out.format("%s of %s%n", card.rankToString(card.getRank()), card.suitToString(card.getSuit()));
            }
        }
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.getArea());

        NumberHolder numberHolder = new NumberHolder(100, 200);
        System.out.println(numberHolder.aFloat + ":  " + numberHolder.anInt);
    }
}

 class NumberHolder {
    public int anInt;
    public float aFloat;

    public NumberHolder(int anInt, float aFloat){
        this.anInt = anInt;
        this.aFloat = aFloat;
    }
}