package tictactoe.src.strategy;


import tictactoe.src.model.Board;
import tictactoe.src.model.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board p);
}
