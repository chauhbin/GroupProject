/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Jayshree Jayshree
 * @author Kirandeep Kaur
 */



public class PlayingCard extends Card {

    public PlayingCard(String suit, int value) {
        super(suit, value);
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }
}
