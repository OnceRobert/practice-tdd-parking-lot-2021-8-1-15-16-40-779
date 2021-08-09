package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy extends ParkingBoy{
    public ParkingTicket park(Car car) {
        int i = 0;
        ParkingLot availableParking = parkingLots.get(0);
        while(availableParking.isFull()&&parkingLots.size()>i){
            availableParking = parkingLots.get(i);
            i++;
        }
        return availableParking.park(car);
    }

}
