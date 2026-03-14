package tictactoe.game;

import java.util.Optional;

public record WinStrat(int score, Optional<Position> pos) {}
