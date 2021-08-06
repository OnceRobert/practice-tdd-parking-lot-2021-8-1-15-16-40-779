package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int maxCapacity = 10;
    //private Car car;
    private Map<ParkingTicket,Car> unclaimedCars = new HashMap<>();
    public ParkingTicket park(Car car) {
        if (maxCapacity == unclaimedCars.size())
            return null;
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
