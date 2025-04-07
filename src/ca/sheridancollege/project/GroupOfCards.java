package ca.sheridancollege.project;


/**
 * A concrete class that represents any grouping of cards for a Game.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author Navdeep Kaur 
 * @author Binderpal Singh Chauhan
 */

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<Card> cards; // List of cards
    private int size; // Maximum size of the group

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards); // Shuffle the cards
    }

    public void addCard(Card card) {
        if (card != null && cards.size() < size) {
            cards.add(card); // Add card if there is space
        }
    }

    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0); // Deal the top card
        }
        return null; // No cards to deal
    }
}