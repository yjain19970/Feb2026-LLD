package strategy;

import model.Board;
import model.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
}
