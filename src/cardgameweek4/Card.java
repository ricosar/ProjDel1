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
    private static int playerSize = 26;
    private static int computerSize = 26;
    private static int computerScore = 0;
    private static int playerScore = 0;
    
    //scores
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
    
    public static int playerSize(){
        return playerSize--;
    }
    
    public static int computerSize(){
        return computerSize--;
    }
    
    public static int computerScore(){
        int score = computerScore + 1;
        return score;
    }
    
    public static int playerScore(){
        int score = playerScore + 1;
        return score;
    }
    
    public static String stringScore(){
        return String.format("%s%d%n%s%d", "The computer score is: ", computerScore(),
                "The player score is: ", playerScore());
    }
    
     @Override
    public int compareTo(Card otherCard) {
        return this.value.compareTo(otherCard.getValue());
    }
    
    }

  


