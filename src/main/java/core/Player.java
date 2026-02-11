package core;

import java.util.Objects;

/**
 *
 */
public class Player {
    private String name;
    private CardStack hand; // containing only 26 cards
    private int score;

    public Player(String name, CardStack hand){
        this.name = name;
        this.hand = hand;   // the Player's hand must be shuffled before constructing.
        score = 0;  // A new Player's score is set to 0.
    }

    public void increaseScore(){
        score++;
    }

    public void resetScore(){
        score = 0;
    }

    public void rename(String newName){
        name = newName;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void shuffleHand(){
        hand.shuffle();
    }

    public Card playCard(){
        return hand.drawOne();
    }

    //Overwritten methods
    public String toString(){
        return "Player: %s\nScore: %d\n".formatted(name, score);
    }

    public boolean equals(Object other){
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }

        Player otherPlayer = (Player)other;
        return name.equals(otherPlayer.name)
                && hand.equals(otherPlayer.hand)
                && score == otherPlayer.score;
    }

    public int hashCode(){
        return Objects.hash(name, hand, score);
    }
}
