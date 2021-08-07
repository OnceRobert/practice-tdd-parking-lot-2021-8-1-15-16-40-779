package com.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public void addParkingLot(ParkingLot danielParkingLot) {
        parkingLots.add(danielParkingLot);
    }

    public ParkingTicket park(Car car) {
        int i = 0;
        ParkingLot availableParking = parkingLots.get(0);
        float maxAvailableSlots = getPercentageOfAvaiableSlots(availableParking);
        while(availableParking.isFull()||maxAvailableSlots<getPercentageOfAvaiableSlots(parkingLots.get(i))){
            availableParking = parkingLots.get(i);
            i++;
            if(parkingLots.size()>i)
                break;
            else
                continue;
        }
        return availableParking.park(car);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car fetchedCar = null;
        for(int i = 0; fetchedCar == null||i<parkingLots.size();i++){
            try{ fetchedCar = parkingLots.get(i).fetch(parkingTicket); }
            catch (Exception e){
                if(parkingLots.size()>i)
                    continue;
                else
                    throw new unrecognizedParkingTicketException();
            }
        }
        return fetchedCar;
    }

    public float getPercentageOfAvaiableSlots(ParkingLot parkingLot){
        float result = (parkingLot.getMaxCapacity() - parkingLot.getNumberParkedCars())/parkingLot.getMaxCapacity() * 100;
        System.out.println(result);
        return result;
    }


}
