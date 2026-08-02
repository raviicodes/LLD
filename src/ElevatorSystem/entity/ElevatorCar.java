package ElevatorSystem.entity;

import ElevatorSystem.enums.Direction;

public class ElevatorCar {
      private  int currentFloor;
      private Direction direction;
      private int nextStoppage;
      private Door door;
    public ElevatorCar() {
         this.currentFloor=0;
         this.direction=Direction.IDLE;
          this.door=new Door();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void openDoor(){
         door.openDoor();
    }
    public void closeDoor(){
        door.closeDoor();
    }

    public int getNextStoppage() {
        return nextStoppage;
    }

    public void setNextStoppage(int nextStoppage) {
        this.nextStoppage = nextStoppage;
    }


    public void moveElevator(int destinationFloor){
         if(currentFloor==destinationFloor){
               openDoor();
                return;
         }

          int startFloor=currentFloor;
          setNextStoppage(destinationFloor);
           closeDoor();
          if(destinationFloor>startFloor){
               setDirection(Direction.UP);
               for(int id=startFloor+1;id<=destinationFloor;id++){
                     try{
                          Thread.sleep(5000);
                     } catch (InterruptedException e) {
                         Thread.currentThread().interrupt();
                     }
                      setCurrentFloor(id);
                      showDisplay();

               }
          }
          else {
              setDirection(Direction.DOWN);
              for(int id=startFloor-1;id>=destinationFloor;id--){
                  try{
                      Thread.sleep(5000);
                  } catch (InterruptedException e) {
                      Thread.currentThread().interrupt();
                  }
                  setCurrentFloor(id);
                  showDisplay();
              }
          }
           openDoor();
    }
    public void showDisplay(){
        System.out.println("currentFloor: "+currentFloor+" direction: "+direction);
    }
}
