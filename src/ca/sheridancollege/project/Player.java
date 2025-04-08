/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Kirandeep Kaur
 * @author Jayshree Jayshree 
 */



public abstract class Player {

    private String name; //the unique name for this player

    public Player(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ✅ Added this for compatibility with getName() calls
    public String getName() {
        return name;
    }

    public abstract void play();
}
