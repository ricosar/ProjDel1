package cardgameweek4;

import java.util.Random;
import java.util.ArrayList;

/**
     * Generates hands for two players for a game of War
     */
public class UpdatedGenerator{
    public static ArrayList<Card>[] generateWarHands() {

        // we'll use this to generate random numbers
        Random random = new Random();

        // let's get these lengths once
        int numValues = Card.Value.values().length;
        int numSuits = Card.Suit.values().length;

        // declare and initialize hands for both players
        ArrayList<Card> player1Hand = new ArrayList<>();
        ArrayList<Card> player2Hand = new ArrayList<>();

        // generate cards for each player's hand
        for (int i = 0; i < 26; i++) {

            // get a random suit and value. Note we're not concerned about uniqueness
            // at this point
            Card.Suit randomSuit = Card.Suit.values()[random.nextInt(numSuits)];
            Card.Value randomValue = Card.Value.values()[random.nextInt(numValues)];

            // create a card and add it to player 1's hand
            Card card = new Card(randomSuit, randomValue);
            player1Hand.add(card);

            // get another random suit and value
            randomSuit = Card.Suit.values()[random.nextInt(numSuits)];
            randomValue = Card.Value.values()[random.nextInt(numValues)];

            // create another card and add it to player 2's hand
            card = new Card(randomSuit, randomValue);
            player2Hand.add(card);

        }

        // store both players' hands in an array and return it
        ArrayList<Card>[] hands = new ArrayList[2];
        hands[0] = player1Hand;
        hands[1] = player2Hand;
        return hands;
    }
}
