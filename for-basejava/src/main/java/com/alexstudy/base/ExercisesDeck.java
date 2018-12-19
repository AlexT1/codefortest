package com.alexstudy.base;

import java.util.List;

/**
 * @ClassName ExercisesDeck
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/11 16:12:55
 */
public class ExercisesDeck {
    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private ExercisesCard[][] cards;

    public ExercisesDeck() {
        cards = new ExercisesCard[numSuits][numRanks];
        for (int suit = ExercisesCard.DIAMONDS; suit <= ExercisesCard.SPADES; suit++) {
            for (int rank = ExercisesCard.ACE; rank <= ExercisesCard.KING; rank++) {
                cards[suit-1][rank-1] = new ExercisesCard(rank, suit);
            }
        }
    }

    public ExercisesCard getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }
}
