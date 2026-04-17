package tictactoe.src.strategy;



public class DiagonalWinningStrategyImpl implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
    }
    
}
