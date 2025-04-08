/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Navdeep Kaur 
 * @author Kirandeep Kaur
 
 */




import java.util.LinkedList;

public class WarPlayer extends Player {
    private LinkedList<PlayingCard> hand;

    public WarPlayer(String name) {
        super(name);
        hand = new LinkedList<>();
    }

    public void receiveCard(PlayingCard card) {
        if (card != null) {
            hand.addLast(card);
        }
    }

    public void receiveCard(PlayingCard[] cards) {
        for (PlayingCard card : cards) {
            receiveCard(card);
        }
    }

    public PlayingCard playCard() {
        return hand.isEmpty() ? null : hand.removeFirst();
    }

    public int getHandSize() {
        return hand.size();
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing.");
    }
}
