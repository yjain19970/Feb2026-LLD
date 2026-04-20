package tictactoe.src.strategy;


import tictactoe.src.exception.NoValidCellFoundException;
import tictactoe.src.model.Board;
import tictactoe.src.model.Move;
import tictactoe.src.model.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board p, Player player) throws NoValidCellFoundException;
}
