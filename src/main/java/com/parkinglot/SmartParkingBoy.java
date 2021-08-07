package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public void addParkingLot(ParkingLot danielParkingLot) {
        parkingLots.add(danielParkingLot);
    }

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

    public int getNumberOfAvaiableSlots(ParkingLot parkingLot){
        return parkingLot.getMaxCapacity() - parkingLot.getNumberParkedCars();
    }


}
