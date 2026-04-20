package factory;

import model.enums.SpotAssignmentStrategyType;
import strategy.RandomSpotAssignmentStrategyImpl;
import strategy.SpotAssignmentStrategy;

public class ParkingSpotAssignmentFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType type){
        switch (type) {
            case RANDOM:
                return new RandomSpotAssignmentStrategyImpl();
            default:
                return new RandomSpotAssignmentStrategyImpl();
        }
    }
}
