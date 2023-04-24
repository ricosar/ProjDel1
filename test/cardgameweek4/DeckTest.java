/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cardgameweek4;

import java.util.Arrays;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;


/**
 *
 * @author brand
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    
    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
public void testShuffleGood() {
    // Create a new deck
    Deck deck = new Deck();

    // Make a copy of the deck before shuffling
    Card[] beforeShuffle = Arrays.copyOf(deck.getDeck(), deck.getDeck().length);

    // Shuffle the deck
    deck.shuffle();

    // Make a copy of the deck after shuffling
    Card[] afterShuffle = Arrays.copyOf(deck.getDeck(), deck.getDeck().length);

    // Assert that the order of the cards has changed
    assertNotEquals(Arrays.toString(beforeShuffle), Arrays.toString(afterShuffle));
}









    /**
     * Test of dealCard method, of class Deck.
     */
    
    
    @Test
public void testShuffleBad() {
    Deck instance = new Deck();
    Card[] originalDeck = instance.getDeck(); // save the original deck
    instance.removeCardsFromDeck(51); // remove all but one card
    Card[] shuffledDeck = instance.getDeck().clone();
    instance.shuffle();
    
    Card remainingCard = null;
    for (int i = 0; i < shuffledDeck.length; i++) {
        if (shuffledDeck[i] != null) {
            remainingCard = shuffledDeck[i];
            break;
        }
    }
    
    Card remainingCard2 = null;
    for (int i = 0; i < originalDeck.length; i++) {
        if (originalDeck[i] != null) {
            remainingCard2 = originalDeck[i];
            break;
        }
    }

System.out.println(Arrays.toString(originalDeck));
System.out.println(Arrays.toString(shuffledDeck));
    
   assertEquals(remainingCard2, remainingCard);
}

@Test
public void testShuffleBoundary() {
    // Test shuffling an empty deck
    Deck instance = new Deck();
    Card[] originalDeck = instance.getDeck(); // save the original deck
    instance.removeCardsFromDeck(52); // remove all cards
    Card[] shuffledDeck = instance.getDeck().clone();
    instance.shuffle();
    
    System.out.println(Arrays.toString(originalDeck));
System.out.println(Arrays.toString(shuffledDeck));
    Assert.assertArrayEquals(originalDeck, shuffledDeck);
    
}

@Test
public void testDealCardGood() {
    Deck deck = new Deck();
    Card expectedCard = deck.getDeck()[0]; // get the first card in the deck
    Card actualCard = deck.dealCard(); // deal the first card
    
    System.out.println(expectedCard);
System.out.println(actualCard);

    // Check that the dealt card is the expected card
    assertEquals(expectedCard, actualCard);
}

@Test
public void testDealCardBad() {
    Deck instance = new Deck();
    instance.removeCardsFromDeck(52); // remove all cards from the deck
    Card dealtCard = instance.dealCard();
    assertNull(dealtCard);
}

@Test
public void testDealCardBoundary() {
    Deck instance = new Deck();
    
    // Deal all cards in the deck
    for (int i = 0; i < 52; i++) {
        Card dealtCard = instance.dealCard();
        assertNotNull(dealtCard);
    }
    
    // Deal one more card than the number of cards in the deck
    Card extraCard = instance.dealCard();
    assertNull(extraCard);
}
}
