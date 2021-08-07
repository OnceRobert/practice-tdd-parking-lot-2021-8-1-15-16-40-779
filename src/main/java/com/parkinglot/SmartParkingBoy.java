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
        int maxAvailableSlots = getNumberOfAvaiableSlots(availableParking);
        while(availableParking.isFull()||maxAvailableSlots<getNumberOfAvaiableSlots(parkingLots.get(++i))){
            try {
                availableParking = parkingLots.get(i);
                maxAvailableSlots = getNumberOfAvaiableSlots(availableParking);
                //i++;
            } catch (Exception e){
                if(parkingLots.size()>i)
                    continue;
                else
                    throw new fullParkingLotException();
            }
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
