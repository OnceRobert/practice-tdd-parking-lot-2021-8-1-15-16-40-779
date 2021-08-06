package com.parkinglot;

import org.junit.jupiter.api.Test;

public class ParkingLotTest {


    @Test
    void should_return parking_ticket_when_park_given_a_parking_lot_and_a_car()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);

    }
}
