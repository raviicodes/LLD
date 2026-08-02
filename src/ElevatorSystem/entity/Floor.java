package ElevatorSystem.entity;

import ElevatorSystem.enums.Direction;

public class Floor {
    private int floorNumber;
    private ExternalButton buttonUp;
    private ExternalButton buttonDown;

    public Floor(int floorNumber, ExternalButton buttonUp, ExternalButton buttonDown) {
        this.floorNumber = floorNumber;
        this.buttonUp = buttonUp;
        this.buttonDown = buttonDown;
    }
    public ExternalRequest pressButton(Direction direction){
         if(direction.equals(Direction.DOWN)) return pressDownButton();
         else return pressUpButton();
    }
    public ExternalRequest pressDownButton(){
         return buttonDown.pressButton(floorNumber);
    }
    public ExternalRequest pressUpButton(){
         return buttonUp.pressButton(floorNumber);
    }
}
