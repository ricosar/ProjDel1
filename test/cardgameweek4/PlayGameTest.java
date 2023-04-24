/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cardgameweek4;

import java.util.Scanner;
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
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 *
 * @author brand
 */
public class PlayGameTest {
    
    public PlayGameTest() {
    }
    
    

    /**
     * Test of divideHand method, of class PlayGame.
     */
@Test
public void testDivideHandGood() {
    PlayGame game = new PlayGame();
    String name = "John";
    game.divideHand(name);
    assertNotNull(game);
}
  @Test
    public void testDivideHandBad() {
        PlayGame game = new PlayGame();

        // Test with invalid input (null name)
        game.divideHand(null);
        assertNotNull(game);
    }
    
  @Test
    public void testPrintHandGood() {
        // Create a new deck and shuffle it
        Deck deck = new Deck();
        deck.shuffle();
        
        // Create a new hand with two cards
        Card[][] hand = new Card[][] {
                { deck.dealCard() },
                { deck.dealCard() }
        };
        
        // Redirect the output stream to a buffer
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(buffer);
        System.setOut(ps);
        
        // Call the printHand method with the hand
        PlayGame.printHand(hand);
        
        // Get the output from the buffer and compare it with the expected output
        String expectedOutput = hand[0][0].toString() + "\n" + hand[1][0].toString() + "\n";
        assertEquals(expectedOutput, buffer.toString());
    }
    
        




 








 
    @Test
    public void testGameScore() {
        System.out.println("gameScore");
        String name = "";
        Card[][] hands = null;
        Deck myDeck = null;
        PlayGame instance = new PlayGame();
        instance.gameScore(name, hands, myDeck);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printHand method, of class PlayGame.
     */
 
    /**
     * Test of endGame method, of class PlayGame.
     */
    @Test
    public void testEndGame() {
        System.out.println("endGame");
        Scanner input = null;
        String startInput = "";
        String name = "";
        PlayGame instance = new PlayGame();
        instance.endGame(input, startInput, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startGame method, of class PlayGame.
     */
    @Test
    public void testStartGame() {
        System.out.println("startGame");
        Scanner input = null;
        String name = "";
        PlayGame instance = new PlayGame();
        instance.startGame(input, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
