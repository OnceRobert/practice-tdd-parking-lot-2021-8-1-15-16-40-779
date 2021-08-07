package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public void addParkingLot(ParkingLot danielParkingLot) {
        parkingLots.add(danielParkingLot);
    }

    public ParkingTicket park(Car car) {
        return this.getParkingLots().get(0).park(car);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car fetchedCar = null;
        for(int i = 0; fetchedCar == null||i<parkingLots.size();i++){
            fetchedCar = parkingLots.get(i).fetch(parkingTicket);
        }
        return fetchedCar;
    }
}
