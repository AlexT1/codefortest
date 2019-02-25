package com.alexstudy.base;

/**
 * @ClassName RewriteCard
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/21 10:25:17
 */
public class RewriteCard {
    private final Rank rank;
    private final Suit suit;

    public RewriteCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }

}
