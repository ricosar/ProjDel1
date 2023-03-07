package cardgameweek4;


import java.util.ArrayList;

/**
 * Starter code for the Card class. To be used in Week 4.
 *
 * @Max Matthews
 */


public class Card {
     
    private int cardNum;
    private int player1Score = 0;
    private int player2Score = 0;
    final static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    final static String[] ranks = {"2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King", "Ace"};
 
     Card (int theCard) {
         setCardNum (theCard);
     }
 
     public void setCardNum (int theCard) {
         cardNum = (theCard >= 0 && theCard <= 51)? theCard: 0;
     }
 
     public int getCardNum() {
         return cardNum;
     }
 
     public String toString() {
         return ranks[cardNum%13] + " of " + suits[cardNum/13];
     }
 
     public String getSuit() {
         return suits[cardNum/13];
     }
 
     public String getRank() {
         return ranks[cardNum%13];
     }
 
     public int getValue() {
         return cardNum%13;
     } 
 }