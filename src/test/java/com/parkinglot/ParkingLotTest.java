package com.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.AssertNull.assertNull;
import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {
    private ByteArrayOutputStream commandLineMessage = new ByteArrayOutputStream();

    @BeforeEach
    public void setup(){
        System.setOut(new PrintStream(commandLineMessage));
    }

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
//    Given a parking lot with two parked cars, and two parking tickets,
//    When fetch the car Twice,
//    Then return the right car with each ticket
    @Test
    public void should_return_correct_cars_when_fetch_twice_given_a_parking_lot_with_two_parked_car_and_two_parking_tickets()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car momoCar = new Car();
        Car jimmyCar = new Car();

        ParkingTicket momoParkingTicket = parkingLot.park(momoCar);
        ParkingTicket jimmyParkingTicket = parkingLot.park(jimmyCar);
        Car expectedMomoCar = momoCar;
        Car expectedJimmyCar = jimmyCar;

        //when
        Car actualMomoCar = parkingLot.fetch(momoParkingTicket);
        Car actualJimmyCar = parkingLot.fetch(jimmyParkingTicket);

        //then
        assertEquals(expectedMomoCar, actualMomoCar);
        assertEquals(expectedJimmyCar, actualJimmyCar);

    }

    @Test
    public void should_return_no_ticket_when_park_given_parking_lot_at_full_capacity()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<Car> tdoongCars = new ArrayList<>();
        List<ParkingTicket> tdoongParkingTickets = new ArrayList<>();
        for(int i = 0; i<10;i++) {
               tdoongCars.add(new Car());
            tdoongParkingTickets.add(parkingLot.park(tdoongCars.get(i)));
        }
        Car excessCar = new Car();
        ParkingTicket expectedTicket = null;
        //when
        //ParkingTicket actualTicket = parkingLot.park(excessCar);

        //then
        Exception exception = assertThrows(fullParkingLotException.class, () -> parkingLot.park(excessCar));

    }

    @Test
    public void should_return_unrecognized_ticket_when_fetch_given_a_parking_lot_with_and_a_used_or_invalid_parking_ticket()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        //Car expectedCar = null;

        //when
        parkingLot.fetch(parkingTicket);
        parkingLot.fetch(parkingTicket);        //Used ticket

        //when
        String expectedMessage = "Unrecognized Ticket\n";

        //then
//        assertEquals(expectedMessage,getCommandLineText());
        Exception exception = assertThrows(unrecognizedParkingTicketException.class, () -> parkingLot.fetch(parkingTicket));
    }

    private String getCommandLineText() {
        return commandLineMessage.toString();
    }

    @Test
    public void should_return_no_available_position_when_park_given_a_parking_lot_at_full_capacity()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<Car> tdoongCars = new ArrayList<>();
        List<ParkingTicket> tdoongParkingTickets = new ArrayList<>();
        for(int i = 0; i<10;i++) {
            tdoongCars.add(new Car());
            tdoongParkingTickets.add(parkingLot.park(tdoongCars.get(i)));
        }
        String expectedMessage = "No Available Position\n";
        Car excessCar = new Car();
        //when
        ParkingTicket actualTicket = parkingLot.park(excessCar);
        //then
        assertEquals(expectedMessage,getCommandLineText());
    }

    @Test
    void should_throw_exception_with_error_message_when_fetch_given_a_parking_lot_and_an_unrecognized_parking_ticket()
    {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        //when
        Exception exception = assertThrows(unrecognizedParkingTicketException.class, () -> parkingLot.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
        //then
    }


}
