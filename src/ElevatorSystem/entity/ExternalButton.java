package ElevatorSystem.entity;

import ElevatorSystem.enums.Direction;

public class ExternalButton {
      private Direction direction;
      private boolean isDisabled;

    public ExternalButton(Direction direction, boolean isDisabled) {
        this.direction = direction;
        this.isDisabled = isDisabled;
    }
    public ExternalRequest pressButton(int floorNumber){
         return new ExternalRequest(floorNumber,direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isDisabled() {
        return isDisabled;
    }
}
