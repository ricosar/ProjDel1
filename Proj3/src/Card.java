

import java.util.ArrayList;

/**
 * Starter code for the Card class. To be used in Week 4.
 *
 * @Max Matthews
 */


public class Card {
     
    //datafields
    private int cardNum;
    
    //arrays that hold suits and ranks
    final static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    final static String[] ranks = {"2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King", "Ace"};
 
    //Card constructor
     Card (int theCard) {
         setCardNum (theCard);
     }
 
    //sets the card
     public void setCardNum (int theCard) {
         cardNum = (theCard >= 0 && theCard <= 51)? theCard: 0;
     }
 
    //returns the card num
     public int getCardNum() {
         return cardNum;
     }
 
    //toString method
     public String toString() {
         return ranks[cardNum%13] + " of " + suits[cardNum/13];
     }
 
    //returns the suit
     public String getSuit() {
         return suits[cardNum/13];
     }
 
    //returns the rank
     public String getRank() {
         return ranks[cardNum%13];
     }
 
    //returns the value
     public int getValue() {
         return cardNum%13;
     } 
 }