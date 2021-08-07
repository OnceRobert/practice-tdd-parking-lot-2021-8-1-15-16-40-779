package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int maxCapacity = 10;
    //private Car car;
    private Map<ParkingTicket,Car> unclaimedCars = new HashMap<>();

    public ParkingLot(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public ParkingLot(){
        maxCapacity = 10;
    }

    public ParkingTicket park(Car car) {
        if (isFull()) {
            System.out.print("No Available Position\n");
            throw new fullParkingLotException();
            //return null;
        }
        //this.car = car;
        ParkingTicket newTicket = new ParkingTicket();
        unclaimedCars.put(newTicket, car);
        //return null;
        return newTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car fetchedCar = null;
            if (isUnrecognizedTicket(parkingTicket)) {
                System.out.print("Unrecognized Ticket\n");
                throw new unrecognizedParkingTicketException();
            }
            fetchedCar = unclaimedCars.get(parkingTicket);
            unclaimedCars.remove(parkingTicket);
            return fetchedCar;
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket){
        return !unclaimedCars.containsKey(parkingTicket);
    }

    private boolean isFull(){
        return unclaimedCars.size() >= maxCapacity;
    }


    public int getNumberParkedCars(){
        return unclaimedCars.size();
    }
}
