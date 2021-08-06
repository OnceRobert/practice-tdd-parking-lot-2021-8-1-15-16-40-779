package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {


    @Test
    public void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);

    }

    @Test
    public void should_return_car_when_fetch_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetch(car);

        //then
        assertEquals(car, actualCar);

    }
}
