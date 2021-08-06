package com.parkinglot;

public class ParkingLot {
    private Car car;
    public ParkingTicket park(Car car) {
        this.car = car;
        //return null;
        return new ParkingTicket();
    }

    public Car fetch(Car car) {
        return car;
    }
}
