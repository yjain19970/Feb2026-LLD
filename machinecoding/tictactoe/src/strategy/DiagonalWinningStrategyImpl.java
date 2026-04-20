package tictactoe.src.strategy;

import java.util.HashMap;
import java.util.Map;

import tictactoe.src.model.Board;
import tictactoe.src.model.Move;

public class DiagonalWinningStrategyImpl implements WinningStrategy {
    private Map<String, Integer> leftDiagonal = new HashMap<>();
    private Map<String, Integer> rightDiagonal = new HashMap<>();

  @Override
    public boolean checkWinner(Board board, Move move) {
        // int row = move.getCell().getRow();
        // int col = move.getCell().getCol();
        // String symbol = move.getPlayer().getSymbol();

        // // Check left diagonal
        // if (row == col) {
        //     leftDiagonal.putIfAbsent(symbol, 0);
        //     leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);

        //     if (leftDiagonal.get(symbol).equals(board.getSize())) {
        //         return true;
        //     }
        // }

        // // Check right diagonal
        // if (row + col == board.getSize() - 1) {
        //     rightDiagonal.putIfAbsent(symbol, 0);
        //     rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);

        //     if (rightDiagonal.get(symbol).equals(board.getSize())) {
        //         return true;
        //     }
        // }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
    }

    
}
