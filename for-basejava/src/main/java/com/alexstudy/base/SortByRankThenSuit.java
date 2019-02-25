package com.alexstudy.base;

import java.util.Comparator;

/**
 * @ClassName SortByRankThenSuit
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/25 16:00:59
 */
public class SortByRankThenSuit implements Comparator<Card> {
    public int compare(Card firstCard, Card secondCard) {
        int compVal =
                firstCard.getRank().value() - secondCard.getRank().value();
        if (compVal != 0)
            return compVal;
        else
            return firstCard.getSuit().value() - secondCard.getSuit().value();
    }
}
