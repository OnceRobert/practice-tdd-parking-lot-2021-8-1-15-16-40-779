package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingBoy {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public void addParkingLot(ParkingLot danielParkingLot) {
        parkingLots.add(danielParkingLot);
    }

    public ParkingTicket park(Car car) {}

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car fetchedCar = null;
        for(int i = 0; fetchedCar == null||i<parkingLots.size();i++){
            try{ fetchedCar = parkingLots.get(i).fetch(parkingTicket); }
            catch (Exception e){
                if(i<parkingLots.size())
                    continue;
                else
                    throw new unrecognizedParkingTicketException();
            }
        }
        try{return fetchedCar;}
        catch (Exception e){throw new unrecognizedParkingTicketException();}
    }
}
