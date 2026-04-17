package tictactoe.src.strategy;

import java.util.HashMap;
import java.util.Map;


public class RowWinningStrategyImpl implements WinningStrategy {
    /**
     * 
     * Creating a hashmap...
     * 
     * For every row in my system, I will have a hashmap. 
     * 
     * <3: <>>
     * 
     * 
     * 
     * 
     * If any of the symbol in hashmp has a count == size of row > 
     * can I say that player has won the game...? 
     */
    private Map<Integer, HashMap<String, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
    /**
     * STEPS:
     * <Board, Move>
     * 1. get the row and you can get the symbol. 
     * 2. get the map for Row number.
     * 3. Update the count in the hashmap
     * 4. Check whether the count is == board.size()
     */
        

        return false;
    }

    /**
     * 
     * Reducing the count for that specific row whenever UNDO is done.
     */
    @Override
    public void handleUndo(Board board, Move move) {
        // Reduce the count simply.

    }
    
}
