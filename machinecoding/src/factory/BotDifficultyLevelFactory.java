package factory;

import model.DifficultyLevel;
import strategy.BotPlayingStrategy;
import strategy.EasyBotPlayingStrategy;
import strategy.HardBotPlayingStrategy;
import strategy.MediumBotPlayingStrategy;

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
