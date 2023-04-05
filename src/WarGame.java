/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a game of War
 */
public class WarGame {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        
        
        Card[][] hands = new Card[2][1];
        Deck myDeck = new Deck();
        myDeck.shuffle();
        
        
        int playerScore = 0;
        int computerScore = 0;
        
    //reduced this to 26 iterations because two cards are dealt each iteration
        for (int i = 0; i < 26; i++) {
            System.out.printf("\n Round %s of The War \n", i);
            for (int player = 0; player < hands.length; player++)
                hands[player][0] = myDeck.dealCard();
            

        for (int player = 0; player < hands.length; player++) {
           
            if(player % 2 == 0){
                 System.out.print(name + "'s Card: ");
            }else{
               System.out.print("Computers card: "); 
            }
            
            printHand(hands[player]);
        }

    //get the value from the Card object
        int player1 = hands[0][0].getValue();
        int player2 = hands[1][0].getValue();

        if (player1 > player2) {
            System.out.println("Player Wins The War");
            System.out.println("The score for computer is: " + computerScore);
            System.out.println("The score for " + name + " is " + ++playerScore);
                
        } else if (player2 > player1) {
            System.out.println("Computer Wins The War");
            System.out.println("The score for computer is: " + ++computerScore);
            System.out.println("The score for " + name + " is " + playerScore);
        } else {
            System.out.println("The War Is A Tie");
            System.out.println("The score for computer is: " + computerScore);
            System.out.println("The score for " + name + " is: " + playerScore);
        }
    }
    }
    public static void printHand(Card[] hand) {

    for (int card = 0; card < hand.length; card++)
        System.out.printf("%s", hand[card].toString());

        System.out.println();
    } 
}
//Main Branch