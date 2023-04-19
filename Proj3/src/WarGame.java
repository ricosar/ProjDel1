/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

        
        System.out.print("\nStart the game? (Y/N): ");
        String startInput = input.nextLine();
        playGame.startGame(startInput, name);
        
   
        if(startInput.equals("y")){
         System.out.print("\nPlay again??? (Y/N): ");
        String endInput = input.nextLine();
        playGame.endGame(endInput, name);
        
        }
       
}
}
