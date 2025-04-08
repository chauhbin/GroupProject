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


public abstract class Card {
    protected String suit;
    protected int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public abstract String toString();
}
