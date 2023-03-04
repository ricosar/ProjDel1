package cardgameweek4;

/**
 * Starter code for the Card class. To be used in Week 4.
 *
 * @author dancye, 2019
 * @modified Paul Bonenfant Feb 2022
 */
public class Card {

   private String suit; 
   private String playerName;

   public Card(String newSuit, String newPlayerName){
       setSuit(newSuit);
       setPlayerName(newPlayerName);
    
   }
   public Card(){
       this("","");
   }
    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param suit the suit to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the value
     */
  
}

