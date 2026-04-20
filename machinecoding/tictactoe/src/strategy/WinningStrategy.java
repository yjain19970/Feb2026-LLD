package tictactoe.src.strategy;

import tictactoe.src.model.Board;
import tictactoe.src.model.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
    
    // handling undo's
    void handleUndo(Board board, Move move);
}
