package cardgameweek4;
import java.util.ArrayList;

/**
 * Starter code for the Card class. To be used in Week 4.
 *
 * @author dancye, 2019
 * @modified Paul Bonenfant Feb 2022
 */
public class Card implements Comparable <Card> {

     private int cardsLeft;
     
    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    private final Suit suit;
    private final Value value;
    

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Value getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }
    
    public void playWar(ArrayList<Card>[] hands) {
        // initialize the number of cards left to the size of the hands array
        cardsLeft = hands[0].size();
    }
    
    public void cardsLeft(){
        System.out.print("There are " + cardsLeft);
    }

   @Override
    public int compareTo(Card otherCard) {
        return this.value.compareTo(otherCard.getValue());
    }
}

