/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgameweek4;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a game of War
 */
public class WarGame {
    public static void main(String[] args) {

        ArrayList<Card> deck = Card.generateDeck();
        ArrayList<Card> Player1 = new ArrayList<>();
        ArrayList<Card> Computer = new ArrayList<>();
        ArrayList<Card> table = new ArrayList<>();

//dealing hands
        while (!deck.isEmpty()) {
            Player1.add(deck.get(0));
            deck.remove(0);
            Computer.add(deck.get(0));
            deck.remove(0);
        }

        while (!Player1.isEmpty() && !Computer.isEmpty()) {
            System.out.println("Player Score: " + Player1.size() + " Computer Score" + Computer.size());
            System.out.println("Player: " + Player1.get(Player1.size() - 1));
            System.out.println("Computer: " + Computer.get(Computer.size() - 1));
            table.add(Player1.get(Player1.size() - 1));
            table.add(Computer.get(Computer.size() - 1));
            Player1.remove(Player1.get(Player1.size() - 1));
            Computer.remove(Computer.get(Computer.size() - 1));

            if (Player1.isEmpty()) {
                System.out.println("Computer wins");
                return;
            }
            else if (Computer.isEmpty()) {
                System.out.println("Player wins");
                return;
            }

            else if (table.get(0).value > table.get(1).value) {
                Player1.addAll(0, table);
                table.clear();
            }
            else if (table.get(0).value < table.get(1).value) {
                Computer.addAll(0, table);
                table.clear();
            }


            else if (table.get(table.size() - 1).value == table.get(table.size() - 2).value) {
                System.out.println("WAR!!!!!!");

                for (int i = 0; i < 2; i++) {
                    table.add(Player1.get(Player1.size() - 1));
                    table.add(Computer.get(Computer.size() - 1));
                    Player1.remove(Player1.get(Player1.size() - 1));
                    Computer.remove(Computer.get(Computer.size() - 1));
                    if (Player1.isEmpty()) {
                        System.out.println("Computer wins");
                        return;
                    }
                    if (Computer.isEmpty()) {
                        System.out.println("Player wins");
                        return;
                    }
                }
                if (table.get(table.size() - 1).value > table.get(table.size() - 2).value) {
                    Player1.addAll(0, table);
                    table.clear();
                }
                else if (table.get(table.size() - 1).value < table.get(table.size() - 2).value) {
                    Computer.addAll(0, table);
                    table.clear();
                }


            }
        }
    }

}
