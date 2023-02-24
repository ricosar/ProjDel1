package cardgameweek4;

/**
 * A class to handle the user interaction for the Card project. Contains a main method that generates a card hand and
 * then iterates over it to print its contents to the console.
 *
 * @author dancye, 2019
 * @modified Paul Bonenfant Feb 2022
 */
public class GamePlayer {

    public static void main(String[] args) {

        Card[] cardHand = CardHandGenerator.generateHand(7);
        for (Card card : cardHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
        // System.out.println(ch.cards); show what happens when there is no toString()
    }

}
