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
            //when & then
            assertThrows(unrecognizedParkingTicketException.class,() -> parkingLot.fetch(null));
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
        //actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertThrows(unrecognizedParkingTicketException.class, () -> parkingLot.fetch(parkingTicket));
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
        //parkingLot.fetch(parkingTicket);        //Used ticket

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
        //when & then
        //assertEquals(expectedMessage,getCommandLineText());
        assertThrows(fullParkingLotException.class, () -> parkingLot.park(excessCar));
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

    @Test
    void should_throw_exception_with_error_message_when_park_given_a_parking_lot_at_full_capacity()
    {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car momoCar = new Car();
        Car minaCar = new Car();
        parkingLot.park(momoCar);

        //when & then
        Exception exception = assertThrows(fullParkingLotException.class, () -> parkingLot.park(minaCar));
        //assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    //TESTS FOR PARKING BOY (STORY 3)
    @Test
    void should_parking_lot_when_standard_parking_boy_add_parking_lot_given_a_parking_lot()
    {
        //given
        ParkingLot danielParkingLot = new ParkingLot();
        //Car jihyoCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(danielParkingLot);

        //when & then
        assertNotNull(danielParkingBoy.getParkingLots());
    }


    @Test
    void should_return_a_parking_ticket_when_standard_parking_boy_given_a_parking_lot_and_a_car()
    {
        //given
        ParkingLot danielParkingLot = new ParkingLot();
        Car jihyoCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(danielParkingLot);

        //when & then
        assertNotNull(danielParkingBoy.park(jihyoCar));
    }

    @Test
    void should_return_a_car_when_standard_parking_boy_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket()
    {
        //given
        ParkingLot danielParkingLot = new ParkingLot();
        Car jihyoCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(danielParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);

        //when & then
        assertEquals(jihyoCar,danielParkingBoy.fetch(jihyoTicket));
    }

    @Test
    void should_return_correct_cars_when_standard_parking_boy_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets()
    {
        //given
        ParkingLot danielParkingLot = new ParkingLot();
        Car jihyoCar = new Car();
        Car sanaCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(danielParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        ParkingTicket sanaTicket = danielParkingBoy.park(sanaCar);

        //when & then
        assertEquals(jihyoCar,danielParkingBoy.fetch(jihyoTicket));
        assertEquals(sanaCar,danielParkingBoy.fetch(sanaTicket));
    }

    @Test
    void should_return_unrecognized_parking_ticket_exception_when_standard_parking_boy_fetch_given_a_parking_lot_and_an_invalid_ticket()
    {
        //given
        ParkingLot danielParkingLot = new ParkingLot();
        ParkingTicket fakeTicket = new ParkingTicket();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(danielParkingLot);

        //when & then
        assertThrows(unrecognizedParkingTicketException.class, () -> danielParkingBoy.fetch(fakeTicket));
    }

    @Test
    void should_no_available_position_when_standard_parking_boy_park_given_a_parking_lot_at_full_capacity()
    {
        //given
        ParkingLot danielParkingLot = new ParkingLot(1);
        Car jihyoCar = new Car();
        Car sanaCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(danielParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);

        //when & then
        //assertEquals(jihyoCar,danielParkingBoy.fetch(jihyoTicket));
        assertThrows(fullParkingLotException.class, () -> danielParkingBoy.park(sanaCar));
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_standard_parking_boy_given_a_parking_lot_with_a_used_parking_ticket()
    {
        //given
        ParkingLot danielParkingLot = new ParkingLot();
        Car jihyoCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(danielParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        jihyoCar = danielParkingBoy.fetch(jihyoTicket);
        //when & then
        assertThrows(unrecognizedParkingTicketException.class, () -> danielParkingBoy.fetch(jihyoTicket));

    }

    //TESTS For story 4 Standard Parking boy
    @Test
    void should_parked_cars_one_is_greater_than_parked_cars_two_when_standard_parking_boy_park_given_two_parking_lots_and_car()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot();
        ParkingLot itzyParkingLot = new ParkingLot();
        Car jihyoCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);

        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);

        //when & then
        assertTrue(danielParkingBoy.getParkingLots().get(0).getNumberParkedCars()>danielParkingBoy.getParkingLots().get(1).getNumberParkedCars());
    }

    @Test
    void should_return_parking_ticket_when_standard_parking_boy_park_given_a_parking_lot_at_full_capacity_and_a_parking_lot_with_available_space()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(1);
        ParkingLot itzyParkingLot = new ParkingLot(5);
        Car jihyoCar = new Car();
        Car chaeryeongCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
        //when & then
        assertNotNull(chaeryeongTicket);
    }

    @Test
    void should_correct_cars_when_standard_parking_boy_fetch_twice_given_two_parking_lots_with_car_parked_two_parking_tickets()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(1);
        ParkingLot itzyParkingLot = new ParkingLot(5);
        Car jihyoCar = new Car();
        Car chaeryeongCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
        //when & then
        assertEquals(jihyoCar, danielParkingBoy.fetch(jihyoTicket));
        assertEquals(chaeryeongCar, danielParkingBoy.fetch(chaeryeongTicket));
    }

    @Test
    void should_no_car_when_standard_parking_boy_fetch_given_two_parking_lots_with_invalid_parking_ticket()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(1);
        ParkingLot itzyParkingLot = new ParkingLot(5);
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);
        ParkingTicket unrecognizedTicket = new ParkingTicket();

        //when & then
        assertThrows(unrecognizedParkingTicketException.class, () -> danielParkingBoy.fetch(unrecognizedTicket));
    }

    @Test
    void should_return_unrecognized_ticket_exception_when_standard_parking_boy_fetch_given_two_parking_lots_and_used_parking_ticket()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(1);
        ParkingLot itzyParkingLot = new ParkingLot(5);
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);

        Car jihyoCar = new Car();
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        jihyoCar = danielParkingBoy.fetch(jihyoTicket);

        //when & then
        assertThrows(unrecognizedParkingTicketException.class, () -> danielParkingBoy.fetch(jihyoTicket));
    }

    @Test
    void should_return_no_available_positions_when_standard_parking_boy_park_given_two_parking_lots_at_full_capacity_and_car()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(1);
        ParkingLot itzyParkingLot = new ParkingLot(1);
        Car jihyoCar = new Car();
        Car chaeryeongCar = new Car();
        Car excessCar = new Car();
        StandardParkingBoy danielParkingBoy = new StandardParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
        //when & then


        assertThrows(fullParkingLotException.class, () -> danielParkingBoy.park(excessCar));
    }


    //TESTS for story 5 smart Parking boy
    @Test
    void should_park_in_parking_lot_two_when_smart_parking_boy_park_given_parking_lot_with_two_cars_and_four_max_capacity_and_a_parking_lot_with_one_car_and_four_max_capacity()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(4);
        ParkingLot itzyParkingLot = new ParkingLot(4);

        Car jihyoCar = new Car();
        Car dahyunCar = new Car();

        Car chaeryeongCar = new Car();
        Car yejiCar = new Car();

        SmartParkingBoy danielParkingBoy = new SmartParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.getParkingLots().get(0).park(jihyoCar);
        ParkingTicket dahyunTicket = danielParkingBoy.getParkingLots().get(0).park(dahyunCar);
        ParkingTicket chaeryeongTicket = danielParkingBoy.getParkingLots().get(1).park(chaeryeongCar);
        int expectedNumberOfCarsInTwo = 2;

        //when
        ParkingTicket yejiTicket = danielParkingBoy.park(yejiCar);


        //then
        assertEquals(expectedNumberOfCarsInTwo,danielParkingBoy.getParkingLots().get(1).getNumberParkedCars());

    }






}
