package cardgameweek4;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Starter code for the Card class. To be used in Week 4.
 *
 * @Max Matthews
 */
public class Card {


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public enum SUITS {SPADES, HEARTS, DIAMONDS, CLUBS}

    ;

    public enum RANKS {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    ;
    SUITS suit;
    RANKS rank;

    int value;

    public RANKS getRank() {
        return rank;
    }

    public void setRank(RANKS rank) {
        this.rank = rank;
    }


    public SUITS getSuit() {
        return suit;
    }

    public void setSuit(SUITS suit) {
        this.suit = suit;
    }

    public Card() {
    }

    public Card(SUITS suit, RANKS rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }


    //the generateDeck method could be used to generate a deck for any card game by changing the values for Ranks and Colors
    public static ArrayList<Card> generateDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < SUITS.values().length; i++) {
            for (int j = 0; j < RANKS.values().length; j++) {

                deck.add(new Card(SUITS.values()[i], RANKS.values()[j], j));
                k++;
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public String toString() {
        return rank + " of " + suit;
    }

}


