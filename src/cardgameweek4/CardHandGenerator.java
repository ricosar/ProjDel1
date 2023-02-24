package cardgameweek4;

import cardgameweek4.Card.Suit;
import cardgameweek4.Card.Value;
import java.util.Random;

/**
 * A class that models the Card Hand. A Card hand has an array of cards. 
 * How can you change the size of the hand?
 *
 * @author dancye, 2019.
 * @modified Paul Bonenfant Feb 2022
 */

public class CardHandGenerator {

    /**
     * Generates a hand of a given size
     */
    public static Card[] generateHand(int handSize) {
        
        // we'll use this to generate random numbers
        Random random = new Random();
        
        // let's get these lengths once
        int numValues = Card.Value.values().length;
        int numSuits = Card.Suit.values().length;
        
        // declare and initialize a hand of cards
        Card[] hand = new Card[handSize];
        
        for (int i = 0; i < handSize; i++) {
            
            // get a random suit and value. Note we're not concerned about uniqueness
            // at this point
            Suit randomSuit = Card.Suit.values()[random.nextInt(numSuits)];
            Value randomValue = Card.Value.values()[random.nextInt(numValues)];
            
            // create a card and add it to the hand
            Card card = new Card(randomSuit, randomValue);        
            hand[i] = card;
            
        }
        
        return hand;
        
        //test
    }
}
