package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public void addParkingLot(ParkingLot danielParkingLot) {
        parkingLots.add(danielParkingLot);
    }

    public ParkingTicket park(Car jihyoCar) {
        return null;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
