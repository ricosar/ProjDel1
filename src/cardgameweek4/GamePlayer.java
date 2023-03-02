package cardgameweek4;

import java.util.ArrayList;


/**
 * A class to handle the user interaction for the Card project. Contains a main method that generates a card hand and
 * then iterates over it to print its contents to the console.
 *
 * @author dancye, 2019
 * @modified Paul Bonenfant Feb 2022
 
public class GamePlayer {

    public static void main(String[] args) {
        
        Card[] cardHand = UpdatedGenerator.generateWarHands(7);
        
         ArrayList<Card> player1Hand = new ArrayList<>();
         ArrayList<Card> player2Hand = new ArrayList<>();
   
         while (player1Hand.cardsLeft() > 0) {
            player1Hand.add(player1Hand.draw());
            player2Hand.add(player2Hand.draw());
            
         int round = 1;
        while (!player1Hand.isEmpty() && !player2Hand.isEmpty()) {
            System.out.println("Round " + round);
            System.out.println("Player 1's card: " + player1Hand.get(0));
            System.out.println("Player 2's card: " + player2Hand.get(0));

            // Compare the cards
            int result = player1Hand.get(0).compareTo(player2Hand.get(0));
            if (result > 0) {
                System.out.println("Player 1 wins this round!");
                player1Hand.add(player2Hand.remove(0));
                player1Hand.add(player1Hand.remove(0));
            } else if (result < 0) {
                System.out.println("Player 2 wins this round!");
                player2Hand.add(player1Hand.remove(0));
                player2Hand.add(player2Hand.remove(0));
            } else {
                System.out.println("It's a tie! Time for war...");
                ArrayList<Card> warCards1 = new ArrayList<Card>();
                ArrayList<Card> warCards2 = new ArrayList<Card>();

                // Each player puts down three cards
                for (int i = 0; i < 3; i++) {
                    if (player1Hand.size() > 1) {
                        warCards1.add(player1Hand.remove(0));
                    }
                    if (player2Hand.size() > 1) {
                        warCards2.add(player2Hand.remove(0));
                    }
                }
// Compare the fourth card
                result = player1Hand.get(0).compareTo(player2Hand.get(0));
                if (result > 0) {
                    System.out.println("Player 1 wins this round!");
                    player1Hand.addAll(warCards1);
                    player1Hand.addAll(warCards2);
                    player1Hand.add(player2Hand.remove(0));
                    player1Hand.add(player1Hand.remove(0));
                } else if (result < 0) {
                    System.out.println("Player 2 wins this round!");
                    player2Hand.addAll(warCards1);
                    player2Hand.addAll(warCards2);
                    player2Hand.add(player1Hand.remove(0));
                    player2Hand.add(player2Hand.remove(0));
                } else {
                    System.out.println("It's a tie again! The war continues...");
                }
            }

            round++;
        }
// Determine the winner
        if (player1Hand.isEmpty()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("Player 1 wins the game!");
        }
    }
        // System.out.println(ch.cards); show what happens when there is no toString()
    }
this is another java code.
}
**/