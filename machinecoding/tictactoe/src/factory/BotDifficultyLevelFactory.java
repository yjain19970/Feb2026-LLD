package tictactoe.src.factory;

import tictactoe.src.model.DifficultyLevel;
import tictactoe.src.strategy.BotPlayingStrategy;
import tictactoe.src.strategy.EasyBotPlayingStrategy;
import tictactoe.src.strategy.HardBotPlayingStrategy;
import tictactoe.src.strategy.MediumBotPlayingStrategy;

public class BotDifficultyLevelFactory {
    
    public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(DifficultyLevel difficultyLevel){
        switch (difficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new MediumBotPlayingStrategy();
            case HARD:
                return new HardBotPlayingStrategy();
            default:
                return new EasyBotPlayingStrategy();
        }
    }
}
