package tictactoe.src.strategy;

import java.util.List;

import tictactoe.src.exception.NoValidCellFoundException;
import tictactoe.src.model.Board;
import tictactoe.src.model.Cell;
import tictactoe.src.model.CellState;
import tictactoe.src.model.Move;
import tictactoe.src.model.Player;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board, Player player) throws NoValidCellFoundException {
        for(List<Cell> cell : board.getBoard()){
            for(Cell c: cell){
                if(c.getCellState().equals(CellState.EMPTY)){
                    return new Move(c, player);
                }
            }
        }
        throw new NoValidCellFoundException("No Empty cell found!");
    }
    
}
