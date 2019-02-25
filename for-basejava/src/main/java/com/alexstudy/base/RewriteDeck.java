package com.alexstudy.base;

/**
 * @ClassName RewriteDeck
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/21 10:37:41
 */
public class RewriteDeck {
    private static RewriteCard[] cards = new RewriteCard[52];
    public RewriteDeck() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new RewriteCard(rank, suit);
            }
        }
    }
}
