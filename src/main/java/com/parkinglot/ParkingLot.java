package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    //private Car car;
    private Map<ParkingTicket,Car> unclaimedCars = new HashMap<>();
    public ParkingTicket park(Car car) {
        //this.car = car;
        ParkingTicket newTicket = new ParkingTicket();
        unclaimedCars.put(newTicket, car);
        //return null;
        return newTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(parkingTicket == null)
            return null;
        else {
            Car fetchedCar = unclaimedCars.get(parkingTicket);
            unclaimedCars.remove(parkingTicket);
            return fetchedCar;
        }
    }
}
