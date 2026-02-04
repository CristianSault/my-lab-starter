package _03_designing_types._50_enums_and_records.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Card(Rank rank, Suit suit) {

    static public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    static public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        public int value() {
            return switch (this) {
                case TWO -> 2;
                case THREE -> 3;
                case FOUR -> 4;
                case FIVE -> 5;
                case SIX -> 6;
                case SEVEN -> 7;
                case EIGHT -> 8;
                case NINE -> 9;
                case TEN, JACK, QUEEN, KING -> 10;
                case ACE -> 11;
            };
        }
    }
//    static public enum Rank {
//        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
//        JACK(10), QUEEN(10), KING(10), ACE(11);
//
//        private final int value;
//
//        Rank(int value) {
//            this.value = value;
//        }
//
//        public int value() {
//            return value;
//        }
//    }

    public static List<Card> gimmeADeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add( new Card(rank, suit) );
            }
        }
        return deck;
    }
}
