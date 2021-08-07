package com.parkinglot;

public class fullParkingLotException extends RuntimeException{
    @Override
    public String getMessage(){
        return "No Available Position.";
    }
}
