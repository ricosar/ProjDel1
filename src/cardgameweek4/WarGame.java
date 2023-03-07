/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgameweek4;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a game of War
 */
public class WarGame {
    public static void main(String[] args){
        Card[][] hands = new Card[2][1];
        Deck myDeck = new Deck();

    //reduced this to 26 iterations because two cards are dealt each iteration
        for (int i = 0; i < 26; i++) {
            System.out.printf("\n Round %s of The War \n", i);
            for (int player = 0; player < hands.length; player++)
                hands[player][0] = myDeck.dealCard();
            

        for (int player = 0; player < hands.length; player++) {
            System.out.printf("Player %d: ", player);
            printHand(hands[player]);
        }

        int player1 = hands[0][0].getValue(); //get the value from the Card object
        int player2 = hands[1][0].getValue();

        if (player1 > player2) {
            System.out.println("Player One Wins The War");
            player1Score++;
        } else if (player2 > player1) {
            System.out.println("Player Two Wins The War");
            player2Score++;
        } else {
            System.out.println("The War Is A Tie");
        }

    }
    }
    public static void printHand(Card[] hand) {

    for (int card = 0; card < hand.length; card++)
        System.out.printf("%s", hand[card].toString());

        System.out.println();
    } 
}
