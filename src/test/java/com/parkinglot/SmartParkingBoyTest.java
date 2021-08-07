package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {

    @Test
    void should_parked_cars_one_is_greater_than_parked_cars_two_when__parking_boy_park_given_two_parking_lots_and_car()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot();
        ParkingLot itzyParkingLot = new ParkingLot();
        Car jihyoCar = new Car();
        SmartParkingBoy danielParkingBoy = new SmartParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);

        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);

        //when & then
        assertTrue(danielParkingBoy.getParkingLots().get(0).getNumberParkedCars()>danielParkingBoy.getParkingLots().get(1).getNumberParkedCars());
    }

    @Test
    void should_return_parking_ticket_when_smart_parking_boy_park_given_a_parking_lot_at_full_capacity_and_a_parking_lot_with_available_space()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(1);
        ParkingLot itzyParkingLot = new ParkingLot(5);
        Car jihyoCar = new Car();
        Car chaeryeongCar = new Car();
        SmartParkingBoy danielParkingBoy = new SmartParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
        //when & then
        assertNotNull(chaeryeongTicket);
    }

//    @Test
//    void should_correct_cars_when_smart_parking_boy_fetch_twice_given_two_parking_lots_with_car_parked_two_parking_tickets()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(5);
//        Car jihyoCar = new Car();
//        Car chaeryeongCar = new Car();
//        SmartParkingBoy danielParkingBoy = new SmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
//        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
//        //when & then
//        assertEquals(jihyoCar, danielParkingBoy.fetch(jihyoTicket));
//        assertEquals(chaeryeongCar, danielParkingBoy.fetch(chaeryeongTicket));
//    }
//
//    @Test
//    void should_no_car_when_smart_parking_boy_fetch_given_two_parking_lots_with_invalid_parking_ticket()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(5);
//        SmartParkingBoy danielParkingBoy = new SmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//        ParkingTicket unrecognizedTicket = new ParkingTicket();
//
//        //when & then
//        assertThrows(unrecognizedParkingTicketException.class, () -> danielParkingBoy.fetch(unrecognizedTicket));
//    }
//
//    @Test
//    void should_return_unrecognized_ticket_exception_when_smart_parking_boy_fetch_given_two_parking_lots_and_used_parking_ticket()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(5);
//        SmartParkingBoy danielParkingBoy = new SmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//
//        Car jihyoCar = new Car();
//        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
//        jihyoCar = danielParkingBoy.fetch(jihyoTicket);
//
//        //when & then
//        assertThrows(unrecognizedParkingTicketException.class, () -> danielParkingBoy.fetch(jihyoTicket));
//    }

//    @Test
//    void should_return_no_available_positions_when_smart_parking_boy_park_given_two_parking_lots_at_full_capacity_and_car()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(1);
//        Car jihyoCar = new Car();
//        Car chaeryeongCar = new Car();
//        Car excessCar = new Car();
//        SmartParkingBoy danielParkingBoy = new SmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
//        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
//        //when & then
//
//        assertThrows(fullParkingLotException.class, () -> danielParkingBoy.park(excessCar));
//    }
}
