package core;

import java.util.ArrayList;

/**
 *
 */
public class CardStack {
    private ArrayList<Card> deck;

    /**
     * Creates and shuffles a new 52 Card Deck
     */
    public CardStack(){
        deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        this.shuffle();
    }

    /**
     * Reshuffles the deck
     */
    public void shuffle() {
        for (Card curr: deck) {
            // switches the curr Card with any random position in the deck
            Card temp = deck.set((int)(Math.random()*deck.size()), curr);
            try {
                deck.add(deck.indexOf(temp), temp);
            } catch (IndexOutOfBoundsException e) {
                // default to append the card to the Stack.
                deck.add(temp);
            }
        }
    }

    /**
     * Deletes the top card in the stack and returns it.
     * @return the Top Card of the Stack
     */
    public Card drawOne() {
        return deck.removeFirst();
    }

    /**
     * @return the amount of Cards left in the Stack
     */
    public int remainingCards(){
        return deck.size();
    }
}
