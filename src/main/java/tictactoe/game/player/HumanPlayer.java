package tictactoe.game.player;

import tictactoe.game.Board;
import tictactoe.game.Position;
import tictactoe.game.Token;
import tictactoe.ui.Console;

/**
 * Derived class of `Player` for human users.
 */
public class HumanPlayer extends Player{

    /**
     * Simply calls the super constructor
     * @param name the name of the player
     * @param token the token the player will play (X/O)
     */
    public HumanPlayer(String name, Token token) {
        super(name, token);
    }

    /**
     * Specific implementation for a human player that asks and verifies a position to play the token,
     * if the position is not valid it will print alert messages to the user.
     * To be later checked at `TicTacToeGame` to place the token in the board.
     *
     * @param board The current state of the board
     * @return the verified, valid position to play the token in an Optional
     */
    @Override
    public Position getNextMove(Board board) {
        while (true) {
            var prompt = "%s's turn (%s). Enter your move (row column): ".formatted(name, token);
            var pos = Console.promptForPosition(prompt, board);

            if (board.isEmptyAt(pos)) {
                return pos;
            }
            Console.printAlert("That position is not valid. Please enter a valid position.");
        }
    }
}
