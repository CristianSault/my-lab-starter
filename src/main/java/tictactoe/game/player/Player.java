package tictactoe.game.player;

import tictactoe.game.Board;
import tictactoe.game.Position;
import tictactoe.game.Token;

/**
 * Modified record to abstract class for additional derived "Player" classes to scale the game logic and functionality.
 */
public abstract class Player {

    protected final String name;
    protected final Token token;

    public Player(String name, Token token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public Token getToken() {
        return token;
    }

    /**
     * Prompts the player to pick their next move.
     * Will continue to prompt until the player picks a valid move (i.e. an empty position on the board)
     * @param board The current state of the board
     * @return The (valid) position on the board where the player wants to place their token
     */
    public abstract Position getNextMove(Board board);

}
