/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Navdeep Kaur
 * @author Binderpal Singh Chauhan
 */
public class Main {
    public static void main(String[] args) {
        WarGame game = new WarGame("War");
        game.addPlayer(new WarPlayer("Player 1"));
        game.addPlayer(new WarPlayer("Player 2"));
        game.play();
        
    }
}