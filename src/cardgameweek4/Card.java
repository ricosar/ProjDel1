package cardgameweek4;


import java.util.ArrayList;

/**
 * Starter code for the Card class. To be used in Week 4.
 *
 * @author dancye, 2019
 * @modified Paul Bonenfant Feb 2022
 */


public class Card implements Comparable <Card> {
     
    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    //suit and value
    private final Suit suit;
    private final Value value;
    
    //scores
    private int playerScore = 0;
    private int computerScore = 0;
    
    public Card(){

    }

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
    
    public int computerWins(){
        return computerScore++;
    }
    
    public int playerWins(){
        return playerScore++;
    }

   @Override
    public int compareTo(Card otherCard) {
        return this.value.compareTo(otherCard.getValue());
    }
}

