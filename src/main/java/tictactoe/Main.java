package tictactoe;

import tictactoe.game.TicTacToeGame;
import tictactoe.game.Token;
import tictactoe.ui.Console;

import static tictactoe.game.TicTacToeGame.Status.*;

class Main {
    static void main() {

        Console.println("Welcome to Tic Tac Toe!");
        Console.println("You may choose a computer player to play against from the following list: ");
        Console.println("1. Circe\t2. Optimus");
        Console.println("You may also have computer players play against each other!\n");
        Console.println("For a normal, human player type whichever name you like");
        Console.println("To make a computer player, use the format '@<name>' where <name> is either Circe, or Optimus.");
        var playerX = Console.promptForPlayer(Token.X);
        var playerO = Console.promptForPlayer(Token.O);
        var game = new TicTacToeGame(playerX, playerO);

        while (game.getStatus() == InProgress) {

            var turnData = game.doNextTurn();

            Console.println("%s plays %s at %s %s".formatted(turnData.whoseTurn().getName(), turnData.whoseTurn().getToken(), turnData.positionPlayed().row(), turnData.positionPlayed().col()));
            Console.showBoard(turnData.newBoardState());

            switch (game.getStatus()) {
                case Draw -> Console.println("It's a draw!");
                case XWins, OWins -> Console.println("%s wins!".formatted(turnData.whoseTurn().getName()));
            }

        }
    }
}