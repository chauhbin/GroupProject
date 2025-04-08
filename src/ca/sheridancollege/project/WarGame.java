package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WarGame extends Game {
    private ArrayList<PlayingCard> deck;

    public WarGame(String name) {
        super(name);
        deck = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                deck.add(new PlayingCard(suit, value));
            }
        }
    }

    @Override
    public void play() {
        // Get player names
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Player 1 name: ");
        String name1 = input.nextLine();
        System.out.print("Enter Player 2 name: ");
        String name2 = input.nextLine();

        getPlayers().add(new WarPlayer(name1));
        getPlayers().add(new WarPlayer(name2));

        Collections.shuffle(deck);
        dealCards();

        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        int round = 1;
        int player1Wins = 0;
        int player2Wins = 0;

        while (player1.hasCards() && player2.hasCards()) {
            System.out.println("\n--- Round " + round + " ---");
            System.out.println(player1.getName() + ": " + player1.getHandSize() + " cards");
            System.out.println(player2.getName() + ": " + player2.getHandSize() + " cards");

            PlayingCard card1 = player1.playCard();
            PlayingCard card2 = player2.playCard();

            if (card1 == null || card2 == null) break;

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            if (card1.getValue() > card2.getValue()) {
                player1.receiveCard(card1);
                player1.receiveCard(card2);
                player1Wins++;
                System.out.println(player1.getName() + " wins the round.");
            } else if (card2.getValue() > card1.getValue()) {
                player2.receiveCard(card1);
                player2.receiveCard(card2);
                player2Wins++;
                System.out.println(player2.getName() + " wins the round.");
            } else {
                System.out.println("It's a tie! Entering WAR...");
                handleWar(player1, player2, card1, card2);
            }

            // Show round win summary
            System.out.println("Scoreboard:");
            System.out.println(player1.getName() + " rounds won: " + player1Wins);
            System.out.println(player2.getName() + " rounds won: " + player2Wins);

            round++;
        }

        System.out.println("\nTotal Rounds Played: " + (round - 1));
    }

    private void dealCards() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) {
                player1.receiveCard(deck.get(i));
            } else {
                player2.receiveCard(deck.get(i));
            }
        }
    }

    private void handleWar(WarPlayer player1, WarPlayer player2, PlayingCard card1, PlayingCard card2) {
        ArrayList<PlayingCard> warPile = new ArrayList<>();
        warPile.add(card1);
        warPile.add(card2);

        while (true) {
            for (int i = 0; i < 3; i++) {
                if (player1.hasCards()) warPile.add(player1.playCard());
                if (player2.hasCards()) warPile.add(player2.playCard());
            }

            PlayingCard warCard1 = player1.playCard();
            PlayingCard warCard2 = player2.playCard();

            if (warCard1 == null || warCard2 == null) break;

            System.out.println(player1.getName() + " plays: " + warCard1);
            System.out.println(player2.getName() + " plays: " + warCard2);

            if (warCard1.getValue() > warCard2.getValue()) {
                warPile.add(warCard1);
                warPile.add(warCard2);
                for (PlayingCard card : warPile) player1.receiveCard(card);
                System.out.println(player1.getName() + " wins the WAR.");
                break;
            } else if (warCard2.getValue() > warCard1.getValue()) {
                warPile.add(warCard1);
                warPile.add(warCard2);
                for (PlayingCard card : warPile) player2.receiveCard(card);
                System.out.println(player2.getName() + " wins the WAR.");
                break;
            } else {
                System.out.println("WAR continues...");
                warPile.add(warCard1);
                warPile.add(warCard2);
            }
        }
    }

    @Override
    public void declareWinner() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        System.out.println("\nFinal Result:");
        if (player1.getHandSize() > player2.getHandSize()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player2.getHandSize() > player1.getHandSize()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game ends in a draw.");
        }
    }
}

