package bookmyshow.entities;

import bookmyshow.enums.SeatType;

public class Seat {
    private String seatId;
    private SeatType seatType;

    public Seat(String seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
