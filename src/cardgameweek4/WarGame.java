package cardgameweek4;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a game of War
 */
public class WarGame {
    public static void main(String[] args){
        //creating scanner object
        Scanner input = new Scanner(System.in);
        
        //asking user for name
        System.out.print("Enter your name: ");
        String name = input.next();
        
        //calling the object
        WarGame test = new WarGame();
        System.out.print(test.playRound());
    }
    
    // the hands of both players
    private ArrayList<Card>[] hands;

    /**
     * Constructor for the War class
     */
    public WarGame() {
        hands = UpdatedGenerator.generateWarHands();
    }

    /**
     * Plays a round of War and returns the winner of the round
     *
     * @return the winning player of the round
     */
    public int playRound() {
        int playerScore = 0;
        int computerScore = 0;
        
        // get the top card from each player's hand
        Card player1Card = hands[0].remove(0);
        Card player2Card = hands[1].remove(0);

        // determine the winner of the round
        int result = player1Card.compareTo(player2Card);
        
       boolean value = true;
        
        while(value == true){
         if (result > 0) {
            System.out.print("Player wins!");
            playerScore++;
            // player 1 wins the round
            hands[0].add(player1Card);
            hands[0].add(player2Card);
            return 1;
        } else if (result < 0) {
            System.out.print("Computer wins!");
            computerScore++;
            // player 2 wins the round
            hands[1].add(player2Card);
            hands[1].add(player1Card);
            return 2;
        } else {
            // it's a tie
            // for simplicity, we will not implement a tiebreaker
            // and just return player 1 as the winner
            System.out.print("Its a tie!");
            hands[0].add(player1Card);
            hands[1].add(player2Card);
            return 0;
        }
    }
    }
    
    /**
     * Plays the entire game of War
     *
     * @return the winning player of the game
     */
    public int playGame() {
        while (hands[0].isEmpty() && hands[1].isEmpty()) {
            playRound();
        }

        if (hands[0].isEmpty()) {
            // player 1 wins the game
            return 1;
        } else {
            // player 2 wins the game
            return 2;
        }
    }
}
        
    

