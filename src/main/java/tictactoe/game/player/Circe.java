package tictactoe.game.player;

import tictactoe.game.*;

/**
 * Derived class of <code>Player</code> for "robotic" users with a <em>circular</em> playing strategy.
 * Circe will begin by playing the center position if possible,
 * then will play subsequent turns in a clockwise flow starting from the top middle position.
 */
public class Circe extends Player{

    public Circe(Token token) {
        super("Circe", token);
    }

    /**
     * Specific implementation for a computer player that plays in a <em>circular</em> motion.
     * To be later checked at <code>TicTacToeGame</code> to place the token in the board.
     *
     * @param board The current state of the board
     * @return the verified, valid position to play the token
     */
    @Override
    public Position getNextMove(Board board){
        var availablePos = board.getEmptyCells();
        Position center = new Position(Row.Middle, Col.Middle);
        Position topMiddle = new Position(Row.Top, Col.Middle);
        Position topRight = new Position(Row.Top, Col.Right);
        Position middleRight = new Position(Row.Middle, Col.Right);
        Position bottomRight = new Position(Row.Bottom, Col.Right);
        Position bottomMiddle = new Position(Row.Bottom, Col.Middle);
        Position bottomLeft = new Position(Row.Bottom, Col.Left);
        Position middleLeft = new Position(Row.Middle, Col.Left);
        Position topLeft = new Position(Row.Top, Col.Left);
            // Begin with the center position
            if (availablePos.contains(center)) {
                return center;
            } // Continue with the clockwise sequence of positions
            else if (availablePos.contains(topMiddle)) {
                return topMiddle;
            } else if (availablePos.contains(topRight)) {
                return topRight;
            } else if (availablePos.contains(middleRight)) {
                return middleRight;
            } else if (availablePos.contains(bottomRight)) {
                return bottomRight;
            } else if (availablePos.contains(bottomMiddle)) {
                return bottomMiddle;
            } else if (availablePos.contains(bottomLeft)) {
                return bottomLeft;
            } else if (availablePos.contains(middleLeft)) {
                return middleLeft;
            } else { // Top-Left
                return topLeft;
            }
    }
}
