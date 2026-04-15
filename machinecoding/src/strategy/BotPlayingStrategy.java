package strategy;

import model.Board;
import model.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board p);
}
