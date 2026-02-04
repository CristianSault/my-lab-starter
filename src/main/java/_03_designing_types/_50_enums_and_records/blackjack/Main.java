package _03_designing_types._50_enums_and_records.blackjack;

import java.util.List;

import static _03_designing_types._50_enums_and_records.blackjack.Card.Rank.*;
import static _03_designing_types._50_enums_and_records.blackjack.Card.Suit.*;

public class Main {

    void main() {

        // var card = new Card(ACE, SPADES);

        Card.gimmeADeck();

        var deck = List.of(
                new Card(ACE, SPADES),
                new Card(KING, HEARTS),
                new Card(TEN, DIAMONDS)
        );

        //IO.println(card);

    }
}
