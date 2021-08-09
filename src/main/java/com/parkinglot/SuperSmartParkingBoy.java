package com.parkinglot;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{

    public ParkingTicket park(Car car) {
        int i = 0;
        ParkingLot availableParking = parkingLots.get(0);
        while(parkingLots.size()>i){
            if(availableParking.isFull()||getPercentageOfFreeSlots(availableParking)<getPercentageOfFreeSlots(parkingLots.get(i))){
                availableParking = parkingLots.get(i);
            }
            i++;
        }

        return availableParking.park(car);
    }

    public int getPercentageOfFreeSlots(ParkingLot parkingLot){
        int result = 100 -( parkingLot.getNumberParkedCars()*100/parkingLot.getMaxCapacity());
        return result;
    }


}
