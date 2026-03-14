package tictactoe.game.player;

import tictactoe.game.*;
import tictactoe.ui.Console;

import java.util.Optional;

/**
 * Derived class of <code>Player</code> for "robotic" users with the <em>most optimal</em> playing strategy.
 * Optimus will always win or draw.
 */
public class Optimus extends Player{

    public Optimus(Token token) {
        super("Optimus", token);
    }

    private WinStrat minimax(Board b, Token whoseTurn) {
        // Base Cases
        if (b.getWinner().isPresent() && b.getWinner().get() == Token.X) {
            return new WinStrat(1, Optional.empty());
        } else if (b.getWinner().isPresent() && b.getWinner().get() == Token.O) {
            return new WinStrat(-1, Optional.empty());
        } else if (b.isFull() && b.getWinner().isEmpty()) {   // draw
            return  new WinStrat(0, Optional.empty());
        }
        // Recursive Case
        WinStrat bestResult = whoseTurn == Token.X ? new WinStrat(-1, Optional.empty()) : new WinStrat(1, Optional.empty());
        for (Position chkPos : b.getEmptyCells()) {
            Board copy = new Board(b);
            copy.place(chkPos, whoseTurn);
            WinStrat chkMove = minimax(copy, whoseTurn.opposite());
            if ( whoseTurn == Token.X && chkMove.score() > bestResult.score()) {
                bestResult = new WinStrat(chkMove.score(), Optional.of(chkPos));
            } else if (whoseTurn == Token.O && chkMove.score() < bestResult.score()) {
                bestResult = new WinStrat(chkMove.score(), Optional.of(chkPos));
            }
        }
        return bestResult;
    }

    /**
     * Specific implementation for a computer player that always plays in the <em>most optimal</em>
     * way possible.
     * To be later checked at <code>TicTacToeGame</code> to place the token in the board.
     *
     * @param board The current state of the board
     * @return the verified, valid position to play the token
     */
    @Override
    public Position getNextMove(Board board) {
        var availablePos = board.getEmptyCells();
        if (availablePos.size() == 9) { // Board completely empty
            return Position.randomPos();
        } else {
            var test = minimax(board, token);
            if (test.pos().isPresent()) {
                return test.pos().get();
            } else {
                Console.printAlert("Something went wrong with Optimus! Resorting to random Position.");
                return Position.randomPos();
            }
        }
    }
}
