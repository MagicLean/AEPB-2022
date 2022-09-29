package com.example.AEPB.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SmartParkingBoyTest {

    @Test
    void should_park_car_in_parking_lot_2_when_smart_parking_boy_valet_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot_2_more_than_parking_lot_1() {
        // given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(new ParkingLot(1, 1), new ParkingLot(2, 2)));
        // when
        Car car = new Car("京A12345");
        Ticket ticket = smartParkingBoy.valetParkingCar(car);
        // then
        assertNotNull(ticket);
        ParkingLot parkingLot = smartParkingBoy.getParkingLotList().get(1);
        assertEquals(ticket, parkingLot.getTicketList().get(0));
        assertEquals(car, parkingLot.getCarList().get(0));
    }

    @Test
    void should_park_car_in_parking_lot_1_when_smart_parking_boy_valet_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot_2_equals_parking_lot_1() {
        // given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(new ParkingLot(1, 1), new ParkingLot(2, 1)));
        // when
        Car car = new Car("京A12345");
        Ticket ticket = smartParkingBoy.valetParkingCar(car);
        // then
        assertNotNull(ticket);
        ParkingLot parkingLot = smartParkingBoy.getParkingLotList().get(0);
        assertEquals(ticket, parkingLot.getTicketList().get(0));
        assertEquals(car, parkingLot.getCarList().get(0));
    }
}
