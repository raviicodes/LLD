package ElevatorSystem.controllers;

import ElevatorSystem.entity.ExternalRequest;
import ElevatorSystem.strategy.ElevatorSelectionStrategy;

import java.util.List;

public class ExternalDispatcher {
    private List<ElevatorController> controllers;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ExternalDispatcher(List<ElevatorController> controllers, ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.controllers = controllers;
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }
    public void dispatchRequest(ExternalRequest request) throws InterruptedException {
        ElevatorController selectedController= elevatorSelectionStrategy.selectElevator(controllers,request);
        selectedController.submitRequest(request);
    }
}
