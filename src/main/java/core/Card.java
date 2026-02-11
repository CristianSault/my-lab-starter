package core;

import java.util.ArrayList;
import java.util.List;

public record Card(Rank rank, Suit suit) {

    static public enum Suit {
        HEARTS('♥'), DIAMONDS('♦'), CLUBS('♣'), SPADES('♠');

        private final char symbol;

        Suit(char symbol) {
            this.symbol = symbol;
        }

        public char symbol() {
            return symbol;
        }
    }

    static public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

}
