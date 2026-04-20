package parkinglot.src.factory;

import parkinglot.src.model.enums.SpotAssignmentStrategyType;
import parkinglot.src.service.SpotAssignmentStrategy;

public class ParkingSpotAssignmentFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType type){
        switch (type) {
            case RAND:
                return new RandomSpotAssignmentStrategyImpl();
            default:
                return new RandomSpotAssignmentStrategyImpl();
        }
    }
}
