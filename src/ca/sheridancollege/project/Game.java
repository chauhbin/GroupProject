/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Kirandeep 
 * @author Jayshree Jayshree
 */

import java.util.ArrayList;

public abstract class Game {
    private ArrayList<Player> players;
    private String gameName;

    public Game(String name) {
        this.gameName = name;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public abstract void play();
    public abstract void declareWinner();
}