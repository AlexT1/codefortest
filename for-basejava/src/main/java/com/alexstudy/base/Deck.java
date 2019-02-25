package com.alexstudy.base;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Deck
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/25 15:54:15
 */
public interface Deck {
    List<Card> getCards();
    Deck deckFactory();
    int size();
    void addCard(Card card);
    void addCards(List<Card> cards);
    void addDeck(Deck deck);
    void shuffle();
    void sort();
    void sort(Comparator<Card> c);
    String deckToString();

    Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException;
}
