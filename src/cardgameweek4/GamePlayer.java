package cardgameweek4;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author brand
 */
public class GamePlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String [] SuitAndValue = {"Two of Hearts", "Two of Diamonds", "Two of Spades", "Two of Clubs",
                                                   "Three of Hearts", "Three of Diamonds", "Three of Spades", "Three of Clubs",
                                                   "Four of Hearts", "Four of Diamonds", "Four of Spades", "Four of Clubs",
                                                   "Five of Hearts", "Five of Diamonds", "Five of Spades", "Five of Clubs",
                                                   "Six of Hearts", "Six of Diamonds", "Six of Spades", "Six of Clubs",
                                                   "Seven of Hearts", "Seven of Diamonds", "Seven of Spades", "Seven of Clubs",
                                                   "Eight of Hearts", "Eight of Diamonds", "Eight of Spades", "Eight of Clubs",
                                                   "Nine of Hearts", "Nine of Diamonds", "Nine of Spades", "Nine of Clubs",
                                                   "Ten of Hearts", "Ten of Diamonds", "Ten of Spades", "Ten of Clubs",
                                                   "Jack of Hearts", "Jack of Diamonds", "Jack of Spades", "Jack of Clubs",
                                                   "Queen of Hearts", "Queen of Diamonds", "Queen of Spades", "Queen of Clubs",
                                                   "King of Hearts", "King of Diamonds", "King of Spades", "King of Clubs",
                                                   "Ace of Hearts", "Ace of Diamonds", "Ace of Spades", "Ace of Clubs"};
        
        String name1;
        String name2;
        String startgame;
        Scanner input = new Scanner(System.in);
        System.out.println("Start Game? Type yes or no: "); 
          startgame = input.next();
        
        if ("yes".equals(startgame)){
        boolean gameIsRunning = true;
        
        while(gameIsRunning){
        
        
        System.out.println("Enter player one name: ");
        
        name1 = input.next();
        
        System.out.println("Enter player two name: ");               
        
        name2 = input.next();
        
        Card player1 = new Card("", name1);
        Card player2 = new Card("", name2);
 
        int roundCounter = 0;
        
        Random rand = new Random();
        
        for (int i = 0; i < SuitAndValue.length; i++){
            int randomIndexToSwap = rand.nextInt(SuitAndValue.length);
			String temp = SuitAndValue[randomIndexToSwap];
			SuitAndValue[randomIndexToSwap] = SuitAndValue[i];
			SuitAndValue[i] = temp;
		}
		
                int splitSize = SuitAndValue.length / 2;
                
                String[] splitArray1 = Arrays.copyOfRange(SuitAndValue, 0, splitSize);
                String[] splitArray2 = Arrays.copyOfRange(SuitAndValue, splitSize, SuitAndValue.length);
                ArrayList player1NewDeck = new ArrayList();
                
                ArrayList player2NewDeck = new ArrayList();
           
                    for(int i = 0; i < splitArray1.length; i++){
                        player1.setSuit(splitArray1[i]);
                        player2.setSuit(splitArray2[i]);
                        int check1;
                        int check2;
                        System.out.println(player1.getPlayerName() + " drew an: " + player1.getSuit());
                        System.out.println(player2.getPlayerName() + " drew an: " + player2.getSuit());
                        check1 = checkValue(player1.getSuit());
                        check2 = checkValue(player2.getSuit());
                        if (check1 < check2){
                            player2NewDeck.add(splitArray1[i]);
                            player2NewDeck.add(splitArray2[i]);
                            System.out.println(player2.getPlayerName() + " won this round! ");
                            
                        } else if (check1 > check2){
                            player1NewDeck.add(splitArray1[i]);
                            player1NewDeck.add(splitArray2[i]);
                            System.out.println(player1.getPlayerName() + " won this round! ");
                            
                        } else {
                            player1NewDeck.remove(splitArray1[i]);
                            player2NewDeck.remove(splitArray2[i]);                        
                        System.out.println("DRAW");
                       
                        
                        }
                        
                    }
                    
                
                System.out.println(player1NewDeck); 
                
                 
                System.out.println(player2NewDeck);
                roundCounter++;
                System.out.println("NEW DECK COUNTER: " +roundCounter);
                
                
                ArrayList player1NewDeck1 = new ArrayList();
                ArrayList player2NewDeck1 = new ArrayList();
                
                boolean isOver = false;
                
                while (isOver == false){
                      Collections.shuffle(player2NewDeck);
                      Collections.shuffle(player1NewDeck);
                   for(int i = 0; i < 5200; i++){
            
                    
                        if ((player1NewDeck.indexOf(player1NewDeck.get(i)) == player2NewDeck.size()-1) || (player2NewDeck.indexOf(player2NewDeck.get(i)) == player2NewDeck.size()-1) ){
                           
                             player1.setSuit((String) player1NewDeck.get(i));
                        player2.setSuit((String) player2NewDeck.get(i));
                        int check3;
                        int check4;
                        System.out.println(player1.getPlayerName() + " drew an: " + player1.getSuit());
                        System.out.println(player2.getPlayerName() + " drew an: " + player2.getSuit());
                        check3 = checkValue(player1.getSuit());
                        check4 = checkValue(player2.getSuit());
                        if (check3 < check4){
                            player2NewDeck1.add((String) player1NewDeck.get(i));
                            player2NewDeck1.add((String) player2NewDeck.get(i));
                            System.out.println(player2.getPlayerName() + " won this round! ");
                          }  if (check3 > check4){
                            player1NewDeck1.add((String) player1NewDeck.get(i));
                            player1NewDeck1.add((String) player2NewDeck.get(i));
                            System.out.println(player1.getPlayerName() + " won this round! ");                           
                        } if (check3 == check4) {
                            player1NewDeck1.remove((String) player1NewDeck.get(i));
                            player2NewDeck1.remove((String) player2NewDeck.get(i));                                                                            
                            
                        System.out.println("DRAW");       
                        System.out.println("Card: " + player1NewDeck.get(i) + " has been removed from the game");
                        System.out.println("Card: " + player2NewDeck.get(i) + " has been removed from the game");
                        }
                            for(int k = i+1; k < player1NewDeck.size(); k++){
                               player1NewDeck1.add((String) player1NewDeck.get(k)); 
                            }
                            System.out.println(player1NewDeck1); 
                
                 
                System.out.println(player2NewDeck1);
                            break;
                        } 
                        if ((player2NewDeck.indexOf(player2NewDeck.get(i)) == player1NewDeck.size()-1) || (player1NewDeck.indexOf(player1NewDeck.get(i)) == player1NewDeck.size()-1)){
                               player1.setSuit((String) player1NewDeck.get(i));
                        player2.setSuit((String) player2NewDeck.get(i));
                        int check5;
                        int check6;
                        System.out.println(player1.getPlayerName() + " drew an: " + player1.getSuit());
                        System.out.println(player2.getPlayerName() + " drew an: " + player2.getSuit());
                        check5 = checkValue(player1.getSuit());
                        check6 = checkValue(player2.getSuit());
                        if (check5 < check6){
                            player2NewDeck1.add((String) player1NewDeck.get(i));
                            player2NewDeck1.add((String) player2NewDeck.get(i));
                            
                            System.out.println(player2.getPlayerName() + " won this round! ");
                          }  if (check5 > check6){
                            player1NewDeck1.add((String) player1NewDeck.get(i));
                            player1NewDeck1.add((String) player2NewDeck.get(i));
                            
                            System.out.println(player1.getPlayerName() + " won this round! ");                           
                        } if (check5 == check6) {
                            player1NewDeck1.remove((String) player1NewDeck.get(i));
                            player2NewDeck1.remove((String) player2NewDeck.get(i));                                                                            
                            
                            
                        System.out.println("DRAW");       
                        System.out.println("Card: " + player1NewDeck.get(i) + " has been removed from the game");
                        System.out.println("Card: " + player2NewDeck.get(i) + " has been removed from the game");
                        }
                             for(int k = i+1; k < player2NewDeck.size(); k++){
                               player2NewDeck1.add((String) player2NewDeck.get(k)); 
                            }
                             System.out.println(player1NewDeck1); 
                
                 
                System.out.println(player2NewDeck1);
                         break;   
                        }
                        
                        player1.setSuit((String) player1NewDeck.get(i));
                        player2.setSuit((String) player2NewDeck.get(i));
                       
                        int check1;
                        int check2;
                        System.out.println(player1.getPlayerName() + " drew an: " + player1.getSuit());
                        System.out.println(player2.getPlayerName() + " drew an: " + player2.getSuit());
                        check1 = checkValue(player1.getSuit());
                        check2 = checkValue(player2.getSuit());
                        
                       
                        if (check1 < check2){
                            player2NewDeck1.add((String) player1NewDeck.get(i));
                            player2NewDeck1.add((String) player2NewDeck.get(i));
                            
                           
                            
                            System.out.println(player2.getPlayerName() + " won this round! ");
                            
                            
                            
                        }  if (check1 > check2){
                            player1NewDeck1.add((String) player1NewDeck.get(i));
                            player1NewDeck1.add((String) player2NewDeck.get(i));
                            
                           
                            
                            System.out.println(player1.getPlayerName() + " won this round! ");
                           
                        } if (check1 == check2) {
                            player1NewDeck1.remove((String) player1NewDeck.get(i));
                            player2NewDeck1.remove((String) player2NewDeck.get(i));                        
                            
                            
                        System.out.println("DRAW");
                        System.out.println("Card: " + player1NewDeck.get(i) + " has been removed from the game");
                        System.out.println("Card: " + player2NewDeck.get(i) + " has been removed from the game");
                        
                        
                        }
                        
                    
                System.out.println(player1NewDeck1); 
                
                 
                System.out.println(player2NewDeck1);
                
                    
                }
                 if (player2NewDeck1.isEmpty()){
                     System.out.println(player1.getPlayerName() + " WINS THE WAR!!");
                     isOver = true;
                 }
                 if (player1NewDeck1.isEmpty()){
                     System.out.println(player2.getPlayerName() + " WINS THE WAR!!");
                     isOver = true;
                 }
                  if(isOver == false){
                    roundCounter++;
                    System.out.println("NEW DECK COUNTER: " +roundCounter);
                   player2NewDeck.clear();
                   player1NewDeck.clear();
                   for (int i = 0; i < player2NewDeck1.size(); i++){
                       player2NewDeck.add((String) player2NewDeck1.get(i));
                   }
                   for (int i = 0; i < player1NewDeck1.size(); i++){
                       player1NewDeck.add((String) player1NewDeck1.get(i));
                   }
                   player2NewDeck1.clear();
                   player1NewDeck1.clear();
              
                } else {
                     player2NewDeck.clear();
                   player1NewDeck.clear(); 
                   player2NewDeck1.clear();
                   player1NewDeck1.clear();
                   
                   System.out.println("New Game? Yes or no");
                   String newGame;
                   newGame = input.next();
                   if ("yes".equals(newGame)){
                       gameIsRunning = true;
                   } else {
                    gameIsRunning = false;   
                   }
                  }
                 
        } 
         
        } 
        
     
    }
            else {
           System.out.println("Okay"); 
        }
        System.out.println("Goodbye"); 
    }
    
      public static int checkValue(String value){
          if (value == "Two of Hearts" || value == "Two of Spades" || value == "Two of Clubs" || value == "Two of Diamonds"){
              return 2;       
      } else if (value == "Three of Hearts" || value == "Three of Spades" || value == "Three of Clubs" || value == "Three of Diamonds"){
              return 3;       
      } else if (value == "Four of Hearts" || value == "Four of Spades" || value == "Four of Clubs" || value == "Four of Diamonds"){
              return 4;       
      } else if (value == "Five of Hearts" || value == "Five of Spades" || value == "Five of Clubs" || value == "Five of Diamonds"){
              return 5;       
      } else if (value == "Six of Hearts" || value == "Six of Spades" || value == "Six of Clubs" || value == "Six of Diamonds"){
              return 6;       
      } else if (value == "Seven of Hearts" || value == "Seven of Spades" || value == "Seven of Clubs" || value == "Seven of Diamonds"){
              return 7;       
      } else if (value == "Eight of Hearts" || value == "Eight of Spades" || value == "Eight of Clubs" || value == "Eight of Diamonds"){
              return 8;       
      } else if (value == "Nine of Hearts" || value == "Nine of Spades" || value == "Nine of Clubs" || value == "Nine of Diamonds"){
              return 9;       
      } else if (value == "Ten of Hearts" || value == "Ten of Spades" || value == "Ten of Clubs" || value == "Ten of Diamonds"){
              return 10;       
      } else if (value == "Jack of Hearts" || value == "Jack of Spades" || value == "Jack of Clubs" || value == "Jack of Diamonds"){
              return 11;       
      } else if (value == "Queen of Hearts" || value == "Queen of Spades" || value == "Queen of Clubs" || value == "Queen of Diamonds"){
              return 12;       
      } else if (value == "King of Hearts" || value == "King of Spades" || value == "King of Clubs" || value == "King of Diamonds"){
              return 13;       
      } else if (value == "Ace of Hearts" || value == "Ace of Spades" || value == "Ace of Clubs" || value == "Ace of Diamonds"){
              return 14;       
      }
        
          return 0;
      }
    }
