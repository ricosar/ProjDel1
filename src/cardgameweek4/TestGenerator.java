/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package cardgameweek4;
import java.util.ArrayList;


/**
 *
 * @author Sarah
 
public class TestGenerator {
    ArrayList<Card>[] hands = UpdatedGenerator.generateWarHands();
    ArrayList<Card> player1Hand = hands[0];
    ArrayList<Card> player2Hand = hands[1];
    
    System.out.println("Player 1's hand:");
 for (Card card : player1Hand) {
     System.out.println(card.getValue() + " of " + card.getSuit());
 }

 System.out.println("\nPlayer 2's hand:");
 for (Card card : player2Hand) {
     System.out.println(card.getValue() + " of " + card.getSuit());
 }
}
* 
* **/
