package com.parkinglot;

public class ParkingLot {
    private Car car;
    public ParkingTicket park(Car car) {
        this.car = car;
        //return null;
        return new ParkingTicket();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(parkingTicket == null)
            return null;
        else {
            Car fetchedCar = this.car;
            car = null;
            return fetchedCar;
        }
    }
}
