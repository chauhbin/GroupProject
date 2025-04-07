/**
 * SYST 17796 Project Base code.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 * @author Navdeep Kaur
 * @author Binderpal Singh Chauhan
 */
public class Card {
    private String suit; 
    private int value;   

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suit + " " + value; // String representation of the card
    }
}
