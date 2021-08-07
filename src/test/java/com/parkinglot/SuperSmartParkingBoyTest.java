package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperSmartParkingBoyTest {

    @Test
    void should_parked_cars_one_is_greater_than_parked_cars_two_when_super_smart_parking_boy_park_given_two_parking_lots_and_car()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot();
        ParkingLot itzyParkingLot = new ParkingLot();
        Car jihyoCar = new Car();
        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);

        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);

        //when & then
        assertEquals(1,danielParkingBoy.getParkingLots().get(0).getNumberParkedCars());
    }

    @Test
    void should_return_parking_ticket_when_super_smart_parking_boy_park_given_a_parking_lot_at_full_capacity_and_a_parking_lot_with_available_space()
    {
        //given
        ParkingLot tdoongParkingLot = new ParkingLot(1);
        ParkingLot itzyParkingLot = new ParkingLot(5);
        Car jihyoCar = new Car();
        Car chaeryeongCar = new Car();
        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
        danielParkingBoy.addParkingLot(tdoongParkingLot);
        danielParkingBoy.addParkingLot(itzyParkingLot);
        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
        //when & then
        assertNotNull(chaeryeongTicket);
    }

//    @Test
//    void should_correct_cars_when_super_smart_parking_boy_fetch_twice_given_two_parking_lots_with_car_parked_two_parking_tickets()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(5);
//        Car jihyoCar = new Car();
//        Car chaeryeongCar = new Car();
//        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
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
//    void should_no_car_when_super_smart_parking_boy_fetch_given_two_parking_lots_with_invalid_parking_ticket()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(5);
//        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//        ParkingTicket unrecognizedTicket = new ParkingTicket();
//
//        //when & then
//        assertThrows(unrecognizedParkingTicketException.class, () -> danielParkingBoy.fetch(unrecognizedTicket));
//    }
//
//    @Test
//    void should_return_unrecognized_ticket_exception_when_super_smart_parking_boy_fetch_given_two_parking_lots_and_used_parking_ticket()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(5);
//        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
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
//
//    @Test
//    void should_return_no_available_positions_when_super_smart_parking_boy_park_given_two_parking_lots_at_full_capacity_and_car()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(1);
//        ParkingLot itzyParkingLot = new ParkingLot(1);
//        Car jihyoCar = new Car();
//        Car chaeryeongCar = new Car();
//        Car excessCar = new Car();
//        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//        ParkingTicket jihyoTicket = danielParkingBoy.park(jihyoCar);
//        ParkingTicket chaeryeongTicket = danielParkingBoy.park(chaeryeongCar);
//        //when & then
//
//        assertThrows(fullParkingLotException.class, () -> danielParkingBoy.park(excessCar));
//    }
//
//    @Test
//    void should_park_in_parking_lot_two_when_super_smart_parking_boy_park_given_parking_lot_with_two_cars_and_four_max_capacity_and_a_parking_lot_with_one_car_and_four_max_capacity()
//    {
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(4);
//        ParkingLot itzyParkingLot = new ParkingLot(4);
//
//        Car jihyoCar = new Car();
//        Car dahyunCar = new Car();
//
//        Car chaeryeongCar = new Car();
//        Car yejiCar = new Car();
//
//        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//        ParkingTicket jihyoTicket = danielParkingBoy.getParkingLots().get(0).park(jihyoCar);
//        ParkingTicket dahyunTicket = danielParkingBoy.getParkingLots().get(0).park(dahyunCar);
//        ParkingTicket chaeryeongTicket = danielParkingBoy.getParkingLots().get(1).park(chaeryeongCar);
//        int expectedNumberOfCarsInTwo = 2;
//
//        //when
//        ParkingTicket yejiTicket = danielParkingBoy.park(yejiCar);
//
//        //then
//        assertEquals(expectedNumberOfCarsInTwo, danielParkingBoy.getNumberOfAvaiableSlots(danielParkingBoy.parkingLots.get(0)));
//        assertEquals(2, danielParkingBoy.getNumberOfAvaiableSlots(danielParkingBoy.parkingLots.get(1)));
//        assertEquals(expectedNumberOfCarsInTwo,danielParkingBoy.getParkingLots().get(1).getNumberParkedCars());
//    }
//
//    @Test
//    void should_park_in_parking_lot_one_when_super_smart_parking_boy_park_given_parking_lot_with_one_car_and_four_max_capacity_and_a_parking_lot_with_three_cars_and_four_max_capacity()
//    {//Given a smart parking boy, a parking lot with 1 parked cars and 4 max capacity and a parking lot with 3 parked car and 4 max capacity
//        //given
//        ParkingLot tdoongParkingLot = new ParkingLot(4);
//        ParkingLot itzyParkingLot = new ParkingLot(4);
//
//        Car jihyoCar = new Car();
//        Car dahyunCar = new Car();
//
//        Car yunaCar = new Car();
//        Car chaeryeongCar = new Car();
//        Car yejiCar = new Car();
//
//        SuperSmartParkingBoy danielParkingBoy = new SuperSmartParkingBoy();
//        danielParkingBoy.addParkingLot(tdoongParkingLot);
//        danielParkingBoy.addParkingLot(itzyParkingLot);
//        ParkingTicket jihyoTicket = danielParkingBoy.getParkingLots().get(0).park(jihyoCar);
//        ParkingTicket yejiTicket = danielParkingBoy.getParkingLots().get(1).park(yejiCar);
//        ParkingTicket yunaTicket = danielParkingBoy.getParkingLots().get(1).park(yunaCar);
//        ParkingTicket chaeryeongTicket = danielParkingBoy.getParkingLots().get(1).park(chaeryeongCar);
//        int expectedNumberOfCarsInOne = 2;
//
//        //when
//        ParkingTicket dahyunTicket = danielParkingBoy.getParkingLots().get(0).park(dahyunCar);
//
//        //then
//        assertEquals(expectedNumberOfCarsInOne,danielParkingBoy.getParkingLots().get(0).getNumberParkedCars());
//    }

}
