package ElevatorSystem.controllers;

import ElevatorSystem.entity.ElevatorCar;
import ElevatorSystem.entity.ExternalRequest;
import ElevatorSystem.enums.Direction;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements  Runnable {
    private final ElevatorCar elevatorCar;
    private final PriorityBlockingQueue<Integer> downQ;
    private final PriorityBlockingQueue<Integer> upQ;

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        this.downQ = new PriorityBlockingQueue<>(11, (a, b) -> Integer.compare(b, a));
        this.upQ = new PriorityBlockingQueue<>();
    }

    synchronized public void submitRequest(ExternalRequest request) {
        int destinationFloor=request.getFloor();
        Direction direction = elevatorCar.getDirection();
        int currentFloor = elevatorCar.getCurrentFloor();
        int nextStoppage = elevatorCar.getNextStoppage();
        if (direction.equals(Direction.IDLE)) {
            if (currentFloor <= destinationFloor) {
                upQ.offer(destinationFloor);
            } else downQ.offer(destinationFloor);
            notify();
        } else {
            if (destinationFloor == nextStoppage) return;
            if (direction == Direction.DOWN) {
                if (destinationFloor > nextStoppage  && !upQ.contains(destinationFloor)) upQ.offer(destinationFloor);
                else if(destinationFloor<nextStoppage && !downQ.contains(destinationFloor)) downQ.offer(destinationFloor);
            } else {
                if (destinationFloor < nextStoppage) downQ.offer(destinationFloor);
                else upQ.offer(destinationFloor);
            }
        }
    }

    @Override
    public void run() {
         controlElevator();
    }
    public void controlElevator(){
            while (true){
                 synchronized (this){
                      while(downQ.isEmpty() && upQ.isEmpty()){
                          try {
                              System.out.println("elevator:" + " is IDLE");
                              elevatorCar.setDirection(Direction.IDLE);
                              wait(); // sleep until request arrives
                          } catch (InterruptedException e) {
                              Thread.currentThread().interrupt();
                          }

                      }
                 }
                  while(!upQ.isEmpty()){
                        int destinationFloor=upQ.poll();
                        System.out.println("serving floor: "+destinationFloor);
                        elevatorCar.moveElevator(destinationFloor);
                  }
                   while(!downQ.isEmpty()){
                        int destinationFloor=downQ.poll();
                       System.out.println("serving floor: "+destinationFloor);
                        elevatorCar.moveElevator(destinationFloor);
                   }
            }
    }
}



