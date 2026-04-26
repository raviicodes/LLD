package bookmyshow.entities;

import bookmyshow.enums.SeatStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    private Movie movie;
    private Map<String, SeatStatus>seatStatusMap;
    private Map<String, ReentrantLock>lockMap;
    private LocalTime startTime;
    private LocalDate showDate;
    public Show(Movie movie, List<Seat> seats, LocalTime startTime,LocalDate showDate){
          this.movie=movie;
          this.startTime=startTime;
           this.showDate=showDate;
           this.seatStatusMap=new HashMap<>();
            for(Seat seat:seats){
                seatStatusMap.put(seat.getSeatId(),SeatStatus.AVAILABLE);
                lockMap.put(seat.getSeatId(),new ReentrantLock());
            }
    }

    public Map<String, SeatStatus> getSeatStatusMap() {
        return seatStatusMap;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public  void confirmSeats(List<Seat>seats){
           for(Seat seat:seats){
               seatStatusMap.put(seat.getSeatId(),SeatStatus.BOOKED);
           }
    }
    public boolean lockSeats(List<Seat>seats){
        List<ReentrantLock>aquiredLocks=new ArrayList<>();
        List<String>sortedSeat= new ArrayList<>(seats.stream().map(Seat::getSeatId).toList());
        Collections.sort(sortedSeat);
                try{
                    // aquirelock
                    for(String  seatId:sortedSeat){
                        ReentrantLock lock=lockMap.get(seatId);
                        lock.lock();
                        aquiredLocks.add(lock);
                    }
                    // availability check
                     for(String seatId:sortedSeat){
                          if(seatStatusMap.get(seatId)!=SeatStatus.AVAILABLE) return false;
                     }
                     // make the status as locked
                     for(String seatId:sortedSeat){
                          seatStatusMap.put(seatId,SeatStatus.LOCKED);
                     }
                      return  true;
                }
                finally {
                     for(ReentrantLock lock:aquiredLocks){
                          lock.unlock();
                     }
                }
    }

     public void releaseSeats(List<Seat>seats){
          for(Seat seat:seats){
              String seatid=seat.getSeatId();
              ReentrantLock lock=lockMap.get(seatid);
              try{
                   lock.lock();
                   seatStatusMap.put(seatid,SeatStatus.AVAILABLE);
              }
              finally {
                  lock.unlock();
              }
          }
     }
}
