/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgameweek4;

/**
 *
 * @author brand
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a game of War
 */
public class WarGame {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        PlayGame playGame = new PlayGame();
        
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        //Passes into the playGame start method
        playGame.startGame(input, name);
       
}
}