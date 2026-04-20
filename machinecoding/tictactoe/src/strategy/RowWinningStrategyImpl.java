package tictactoe.src.strategy;

import java.util.HashMap;
import java.util.Map;

import tictactoe.src.model.Board;
import tictactoe.src.model.Move;


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
        int rowNo = move.getCell().getRow();
        String symbol = move.getCell().getPlayer().getSymbol();

        if(!counts.containsKey(rowNo)){
            counts.put(rowNo, new HashMap<>());
        }

        Map<String,Integer> internalMap = counts.get(rowNo);
        if(!internalMap.containsKey(symbol)){
            internalMap.put(symbol, 0);
        }

        internalMap.put(symbol, internalMap.get(symbol)+1);

        if(internalMap.get(symbol).equals(board.getSize())){
            return true;
        }

        return false;
    }

    /**
     * 
     * Reducing the count for that specific row whenever UNDO is done.
     */
    @Override
    public void handleUndo(Board board, Move move) {
        int rowNo = move.getCell().getRow();
        String symbol = move.getCell().getPlayer().getSymbol();
        Map<String,Integer> internalMap = counts.get(rowNo);
        System.out.println("intermap: " + internalMap);

        internalMap.put(symbol, internalMap.get(symbol)-1);
    }
    
}
