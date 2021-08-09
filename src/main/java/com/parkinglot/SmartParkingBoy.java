package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public ParkingTicket park(Car car) {
        int i = 0;
        ParkingLot availableParking = parkingLots.get(0);
        while(parkingLots.size()>i){
            if(availableParking.isFull()||getNumberOfAvaiableSlots(availableParking)<getNumberOfAvaiableSlots(parkingLots.get(i))){
                availableParking = parkingLots.get(i);
            }
            i++;
        }
        return availableParking.park(car);
    }

    public int getNumberOfAvaiableSlots(ParkingLot parkingLot){
        return parkingLot.getMaxCapacity() - parkingLot.getNumberParkedCars();
    }
}
