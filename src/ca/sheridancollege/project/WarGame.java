package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarGame extends Game {
    private GroupOfCards deck; // The deck of cards used in the game

    public WarGame(String name) {
        super(name);
        deck = new GroupOfCards(52); // Standard deck of 52 cards
        initializeDeck(); // Initialize the deck
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) { // Ace high (14)
                deck.addCard(new PlayingCard(suit, value));
            }
        }
    }

    @Override
    public void play() {
        deck.shuffle(); // Shuffle the deck before playing
        dealCards(); // Distribute the cards equally to players

        while (playersStillInGame()) {
            System.out.println("Current card counts: " +
                getPlayers().get(0).getPlayerName() + ": " + ((WarPlayer) getPlayers().get(0)).getHandSize() +
                ", " + getPlayers().get(1).getPlayerName() + ": " + ((WarPlayer) getPlayers().get(1)).getHandSize());

            playRound(); // Play one round
        }
        declareWinner(); // Declare the winner
    }

    protected void dealCards() {
        int playerCount = getPlayers().size();
        for (int i = 0; i < 52; i++) {
            WarPlayer player = (WarPlayer) getPlayers().get(i % playerCount);
            player.receiveCard(deck.dealCard());
        }
    }

    private boolean playersStillInGame() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);
        return player1.hasCards() && player2.hasCards();
    }

    private void playRound() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        Card card1 = player1.playCard();
        Card card2 = player2.playCard();

        // If either player has no more cards, the game ends
        if (card1 == null || card2 == null) {
            return; // Stops the game if any player runs out of cards
        }

        System.out.println(player1.getPlayerName() + " plays: " + card1);
        System.out.println(player2.getPlayerName() + " plays: " + card2);

        // Compare card values to determine the round's winner
        if (card1.getValue() > card2.getValue()) {
            System.out.println(player1.getPlayerName() + " wins the round.");
            player1.receiveCard(card1); // Winner takes both cards
            player1.receiveCard(card2);
        } else if (card2.getValue() > card1.getValue()) {
            System.out.println(player2.getPlayerName() + " wins the round.");
            player2.receiveCard(card1);
            player2.receiveCard(card2);
        } else {
            System.out.println("It's a tie! Entering War...");
            handleWar(player1, player2, card1, card2);
        }
    }

    public void handleWar(WarPlayer player1, WarPlayer player2, Card card1, Card card2) {
    ArrayList<Card> warPile = new ArrayList<>();
    warPile.add(card1);
    warPile.add(card2);

    while (true) {
        // Players place 3 cards face down (if they have enough cards)
        for (int i = 0; i < 3; i++) {
            if (player1.hasCards()) {
                warPile.add(player1.playCard());
            }
            if (player2.hasCards()) {
                warPile.add(player2.playCard());
            }
        }

        // Players play one card face up
        Card warCard1 = player1.playCard();
        Card warCard2 = player2.playCard();

        // If either player cannot continue, they lose
        if (warCard1 == null || warCard2 == null) {
            break;
        }

        System.out.println(player1.getPlayerName() + " plays: " + warCard1);
        System.out.println(player2.getPlayerName() + " plays: " + warCard2);

        // Compare the values of the face-up cards
        if (warCard1.getValue() > warCard2.getValue()) {
            System.out.println(player1.getPlayerName() + " wins the War.");
            player1.receiveCard(warCard1);
            player1.receiveCard(warCard2);
            for (Card c : warPile) { // Add all cards in the warPile
                player1.receiveCard(c);
            }
            break;
        } else if (warCard2.getValue() > warCard1.getValue()) {
            System.out.println(player2.getPlayerName() + " wins the War.");
            player2.receiveCard(warCard1);
            player2.receiveCard(warCard2);
            for (Card c : warPile) { // Add all cards in the warPile
                player2.receiveCard(c);
            }
            break;
        } else {
            System.out.println("The War continues...");
            warPile.add(warCard1);
            warPile.add(warCard2);
        }
    }
}


    @Override
    public void declareWinner() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        if (player1.getHandSize() > player2.getHandSize()) {
            System.out.println(player1.getPlayerName() + " wins the game!");
        } else if (player2.getHandSize() > player1.getHandSize()) {
            System.out.println(player2.getPlayerName() + " wins the game!");
        } else {
            System.out.println("The game ends in a draw!");
        }
    }
}
