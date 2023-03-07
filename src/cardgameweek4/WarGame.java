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
             
        //calling method
          System.out.print(test.playRound());  
        
    }
    
    // the hands of both players
    private ArrayList<Card>[] hands;

    /**
     * Plays a round of War and returns the winner of the round
     *
     * @return the winning player of the round
     */
    public String playRound() {
        
        hands = UpdatedGenerator.generateWarHands();
        
        // get the top card from each player's hand
        Card player1Card = hands[0].remove(0);
        Card player2Card = hands[1].remove(0);

        // determine the winner of the round
        int result = player1Card.compareTo(player2Card);
        
            if (result > 0) {
                Card.playerSize();
                Card.playerScore();
                System.out.print(Card.stringScore());
                // player 1 wins the round return "Player wins!";
                hands[0].add(player1Card);
                hands[0].add(player2Card);
                return "\nPlayer wins!";
                
            } else if (result < 0) { 
                Card.computerSize();
                Card.computerScore();
                System.out.print(Card.stringScore());
                // player 2 wins the round
                hands[1].add(player2Card);
                hands[1].add(player1Card);
                return "\nComputer wins!";
            } else {
                // it's a tie
                // for simplicity, we will not implement a tiebreaker
                // and just return player 1 as the winner
                hands[0].add(player1Card);
                hands[1].add(player2Card);
                return "Its a tie!";
            }
        }
    
    
    /**
     * Plays the entire game of War
     *
     * @return the winning player of the game
     */
    public String playGame() {
        while (hands[0].isEmpty() && hands[1].isEmpty()) {
            playRound();
        }

        if (hands[0].isEmpty()) {
            // player 1 wins the game
            return "Player wins!";
        } else {
            // player 2 wins the game
            return "Computer wins!";
        }
    }
}
        
    

