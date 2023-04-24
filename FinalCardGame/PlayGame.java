package cardgameweek4;


import cardgameweek4.Deck;
import cardgameweek4.Card;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sarah
 */
public class PlayGame {
    
    //datafields
    int playerScore = 0;
    int computerScore = 0;
        
    //divide hand method
    public void divideHand(String name){
      Card[][] hands = new Card[2][1];
        Deck myDeck = new Deck();
        myDeck.shuffle();
        
        //passing into gameScore method
        gameScore(name, hands, myDeck);
    }
    
    //gameScore Method
    public void gameScore(String name, Card[][] hands, Deck myDeck) {
    for (int i = 0; i < 26; i++) {
        System.out.printf("\n Round %s of The War \n", i + 1);
        for (int player = 0; player < hands.length; player++)
            hands[player][0] = myDeck.dealCard();
        
        //passes cards into printHand method
        System.out.print(name + "'s Card: ");
        printHand(new Card[][] { { hands[0][0] } });
        System.out.print("Computer's card: ");
        printHand(new Card[][] { { hands[1][0] } });
        
        //Retrieves values
        int player1 = hands[0][0].getValue();
        int player2 = hands[1][0].getValue();
        
        if (player1 > player2) {
            System.out.println("Player Wins The War");
            playerScore++;
        } else if (player2 > player1) {
            System.out.println("Computer Wins The War");
            computerScore++;
        } else {
            System.out.println("The War Is A Tie");
        }
        
        System.out.println("The score for computer is: " + computerScore);
        System.out.println("The score for " + name + " is: " + playerScore);
    }
}
    
    //printHand method prints the card using toString
    public static void printHand(Card[][] hands) {
    for (int player = 0; player < hands.length; player++) {
        for (int card = 0; card < hands[player].length; card++) {
            System.out.print(hands[player][card].toString() + " ");
        }
        
        System.out.println();
    }
}
    
    //end game method
    public void endGame(Scanner input, String startInput, String name){
        
        String endInput = "";
        
        if(playerScore > computerScore){
            System.out.print("\n" + name + " wins with a score of: " +
                    playerScore);
        }else{
            System.out.print("\nComputer wins with a score of: " + 
                    computerScore);
        }
        
        if(startInput.toLowerCase().equals("y")){
         System.out.print("\nContinue playing? (Y/n): ");
        endInput = input.nextLine();
        }
        
      if(endInput.toLowerCase().equals("y")){
          System.out.print("\nThe game will now be continued if confirmed..\n");
          startGame(input, name); //Passes into startGame method
      }else{
          System.out.print("\nInvalid input. Terminating the game..!\n");
          
      }
    }
    
    //start game method
    public void startGame(Scanner input, String name){
        
          System.out.print("\nStart the game? (Y/n): ");
        String startInput = input.nextLine();
        
     if(startInput.toLowerCase().equals("y")){
          System.out.print("Game starting up..\n");
          divideHand(name);
          endGame(input, startInput, name);
      }else{
          System.out.print("\nInvalid input. Terminating the game..");
          
      }
    }
    
}
    


