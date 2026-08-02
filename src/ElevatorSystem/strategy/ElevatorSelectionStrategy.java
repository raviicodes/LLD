package ElevatorSystem.strategy;

import ElevatorSystem.controllers.ElevatorController;
import ElevatorSystem.entity.ExternalRequest;

import java.util.List;

public interface ElevatorSelectionStrategy {
    public ElevatorController selectElevator(List<ElevatorController>elevatorControllers, ExternalRequest request);
}
