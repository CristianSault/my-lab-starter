package tictactoe.game;

/**
 * A data type to represent each token on the board
 */
public enum Token { X, O;
    public Token opposite() {
        if (this == X) {
            return O;
        } else {
            return X;
        }
    }
}
