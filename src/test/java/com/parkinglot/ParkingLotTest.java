package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);

    }

//
//    Given a parking lot, and a invalid/no parking ticket
//    When fetch the car
//    Then return no car.
        @Test
        public void should_return_no_car_when_fetch_given_a_parking_lot_with_and_invalid_no_parking_ticket()
        {
            //given
            ParkingLot parkingLot = new ParkingLot();
            Car car2 = new Car();
            ParkingTicket parkingTicket = parkingLot.park(car2);
            Car carExpected = null;
            //when
            Car actualCar = parkingLot.fetch(null);

            //then
            assertEquals(carExpected, actualCar);

        }
//
//    Given a parking lot, and an already used parking ticket
//    When fetch the car
//    Then return no car.

    @Test
    public void should_return_no_car_when_fetch_given_a_parking_lot_with_and_a_used_parking_ticket()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        Car expectedCar = null;
        //when
        Car actualCar = parkingLot.fetch(parkingTicket);
        actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(expectedCar, actualCar);

    }

}
