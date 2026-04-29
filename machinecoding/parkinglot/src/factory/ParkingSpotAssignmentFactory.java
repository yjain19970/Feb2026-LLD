package factory;

import model.enums.SpotAssignmentStrategyType;
import strategy.AssignFirstEmptySpotStrategy;
import strategy.ManualSpotAssignmentStrategy;
import strategy.RandomSpotAssignmentStrategyImpl;

public class ParkingSpotAssignmentFactory {
    
    public static strategy.SpotAssignmentStrategy getSpotAssignmentByType(SpotAssignmentStrategyType type){
        switch (type) {
            case MANUAL:
                return new ManualSpotAssignmentStrategy();
            case RANDOM:
                return new RandomSpotAssignmentStrategyImpl();
            case ASSIGN_FIRST_EMPTY:
                return new AssignFirstEmptySpotStrategy();
            default:
                return new ManualSpotAssignmentStrategy();
        }
    }
}
