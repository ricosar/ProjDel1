/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Max Matthews
 */
public class Deck {

    //array of 52 cards in the deck
    private Card[] deck = new Card[52];
    
    //topCard datafield
    private int topCard;

    //Deck constructor
    Deck() {

        topCard = 0;

        for (int i = 0; i < deck.length; i++)
            deck[i] = new Card(i);

    }

    //Shuffles deck
    public void shuffle() {

        topCard = 0;

        //shuffles the deck using Math.random
        for (int i = 0; i < 1000; i++) {
            int j = (int)(Math.random()*52);
            int k = (int)(Math.random()*52);
            Card tmpCard = deck[j];
            deck[j] = deck[k];
            deck[k] = tmpCard;
        } 
   }

    //deals the card to the players
    public Card dealCard() {
        Card theCard;
        if (topCard < deck.length) {
            theCard = deck[topCard];
            topCard++;
        }
        else
            theCard = null;

        return theCard;
    }
}