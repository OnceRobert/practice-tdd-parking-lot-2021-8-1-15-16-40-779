package com.parkinglot;

public class unrecognizedParkingTicketException extends RuntimeException{
    @Override
    public String getMessage(){
        return "Unrecognized parking ticket.";
    }
}
