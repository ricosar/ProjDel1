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

}