package tictactoe.game.player;

import org.junit.jupiter.api.Test;
import tictactoe.game.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {

    // ==================== CIRCE TESTS ====================

    /**
     * Circe should pick the center when the board is empty
     */
    @Test
    public void circe_picksCenter_whenBoardIsEmpty() {
        Circe circe = new Circe(Token.X);
        Board board = new Board();
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Middle, Col.Middle), move);
    }

    /**
     * Circe should pick top-middle when center is taken
     */
    @Test
    public void circe_picksTopMiddle_whenCenterTaken() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("----X----"); // center taken
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Top, Col.Middle), move);
    }

    /**
     * Circe should pick top-right when center and top-middle are taken
     */
    @Test
    public void circe_picksTopRight_whenCenterAndTopMiddleTaken() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("-X--X----"); // center and top-middle taken
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Top, Col.Right), move);
    }

    /**
     * Circe should pick middle-right when center, top-middle, top-right are taken
     */
    @Test
    public void circe_picksMiddleRight_whenClockwisePriorityFollowed() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("-XX-X----"); // center, top-middle, top-right taken
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Middle, Col.Right), move);
    }

    /**
     * Circe should pick bottom-right when higher priority positions are taken
     */
    @Test
    public void circe_picksBottomRight_whenHigherPriorityTaken() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("-XX-XX---"); // center, top-middle, top-right, middle-right taken
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Bottom, Col.Right), move);
    }

    /**
     * Circe should pick bottom-middle when higher priority positions are taken
     */
    @Test
    public void circe_picksBottomMiddle_whenHigherPriorityTaken() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("-XX-XX--X"); // center through bottom-right taken
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Bottom, Col.Middle), move);
    }

    /**
     * Circe should pick bottom-left when higher priority positions are taken
     */
    @Test
    public void circe_picksBottomLeft_whenHigherPriorityTaken() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("-XX-XX-XX"); // center through bottom-middle taken
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Bottom, Col.Left), move);
    }

    /**
     * Circe should pick middle-left when higher priority positions are taken
     */
    @Test
    public void circe_picksMiddleLeft_whenHigherPriorityTaken() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("-XX-XXXXX"); // center through bottom-left taken
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Middle, Col.Left), move);
    }

    /**
     * Circe should pick top-left when it is the only remaining position
     */
    @Test
    public void circe_picksTopLeft_whenOnlyPositionLeft() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("-XXXXXXXX"); // only top-left is empty
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Top, Col.Left), move);
    }

    /**
     * Circe should pick center even if it's the only position left
     */
    @Test
    public void circe_picksCenter_whenOnlyPositionLeft() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("XXXX-XXXX"); // only center is empty
        Position move = circe.getNextMove(board);
        assertEquals(new Position(Row.Middle, Col.Middle), move);
    }

    /**
     * Circe's move should always be an empty cell on the board
     */
    @Test
    public void circe_alwaysReturnsEmptyCell() {
        Circe circe = new Circe(Token.X);
        Board board = new Board("XO-OX----");
        Position move = circe.getNextMove(board);
        assertTrue(board.isEmptyAt(move));
    }


    // ==================== OPTIMUS TESTS ====================

    /**
     * Optimus on an empty board should return a valid position
     */
    @Test
    public void optimus_returnsValidPosition_onEmptyBoard() {
        Optimus optimus = new Optimus(Token.X);
        Board board = new Board();
        Position move = optimus.getNextMove(board);
        assertNotNull(move);
        assertTrue(board.isEmptyAt(move));
    }

    /**
     * Optimus should always return an empty cell
     */
    @Test
    public void optimus_alwaysReturnsEmptyCell() {
        Optimus optimus = new Optimus(Token.X);
        Board board = new Board("XO-OX----");
        Position move = optimus.getNextMove(board);
        assertNotNull(move);
        assertTrue(board.isEmptyAt(move));
    }

    /**
     * Optimus (X) should win or draw when playing against itself from a near-complete board
     * where X can win immediately
     */
    @Test
    public void optimus_winsImmediately_whenWinAvailable() {
        Optimus optimus = new Optimus(Token.X);
        // X has top row nearly complete, O is not threatening
        Board board = new Board("""
                XX-
                OO-
                ---
                """);
        Position move = optimus.getNextMove(board);
        board.place(move, Token.X);
        assertEquals(Token.X, board.getWinner().orElse(null));
    }

    /**
     * Optimus (O) should block X from winning
     */
    @Test
    public void optimus_blocks_opponentWin() {
        Optimus optimus = new Optimus(Token.O);
        // X is about to win with top row
        Board board = new Board("""
                XX-
                O--
                ---
                """);
        Position move = optimus.getNextMove(board);
        board.place(move, Token.O);
        // X should NOT have won
        assertNotEquals(Token.X, board.getWinner().orElse(null));
    }

    /**
     * Optimus should never lose — simulate a full game of Optimus (X) vs Circe (O)
     * and assert the result is a win for X or a draw
     */
    @Test
    public void optimus_neverLoses_vsCirce() {
        Optimus optimus = new Optimus(Token.X);
        Circe circe = new Circe(Token.O);
        Board board = new Board();

        Player current = optimus;
        while (!board.isFull() && board.getWinner().isEmpty()) {
            Position move = current.getNextMove(board);
            board.place(move, current.getToken());
            current = current == optimus ? circe : optimus;
        }

        // Optimus (X) should never lose
        assertNotEquals(Token.O, board.getWinner().orElse(null));
    }

    /**
     * Optimus vs Optimus should always draw
     */
    @Test
    public void optimus_vs_optimus_alwaysDraws() {
        Optimus optimusX = new Optimus(Token.X);
        Optimus optimusO = new Optimus(Token.O);
        Board board = new Board();

        Player current = optimusX;
        while (!board.isFull() && board.getWinner().isEmpty()) {
            Position move = current.getNextMove(board);
            board.place(move, current.getToken());
            current = current == optimusX ? optimusO : optimusX;
        }

        assertTrue(board.getWinner().isEmpty());
    }

    /**
     * Optimus (O) should never lose — simulate a full game of Circe (X) vs Optimus (O)
     */
    @Test
    public void optimus_neverLoses_asO_vsCirce() {
        Circe circe = new Circe(Token.X);
        Optimus optimus = new Optimus(Token.O);
        Board board = new Board();

        Player current = circe;
        while (!board.isFull() && board.getWinner().isEmpty()) {
            Position move = current.getNextMove(board);
            board.place(move, current.getToken());
            current = current == circe ? optimus : circe;
        }

        // Optimus (O) should never lose
        assertNotEquals(Token.X, board.getWinner().orElse(null));
    }
}