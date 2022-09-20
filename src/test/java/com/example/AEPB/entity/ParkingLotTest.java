package com.example.AEPB.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @Test
    void should_get_ticket_when_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(100);
        // when
        Ticket ticket = parkingLot.parkingCar(car);
        // then
        assertNotNull(ticket);
        assertEquals(99, parkingLot.getRemainingSpaceCount());
    }

    @Test
    void should_throw_exception_when_parking_car_given_valid_car_and_no_space_in_parking_lot() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.parkingCar(car));
        // then
        assertEquals("没有剩余车位，停车失败", result.getMessage());
    }

    @Test
    void should_throw_exception_when_parking_car_given_no_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.parkingCar(null));
        // then
        assertEquals("没有车辆，停车失败", result.getMessage());
    }

    @Test
    void should_get_the_car_when_pick_up_car_given_valid_ticket_and_the_car_in_the_parking_lot() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        Car existedCar = new Car();
        Ticket ticket = parkingLot.parkingCar(existedCar);
        // when
        Car car = parkingLot.pickUpCar(ticket);
        // then
        assertEquals(existedCar, car);
        assertEquals(1, parkingLot.getRemainingSpaceCount());
    }

    @Test
    void should_throw_exception_when_pick_up_car_given_no_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        Car existedCar = new Car();
        Ticket ticket = parkingLot.parkingCar(existedCar);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.pickUpCar(null));
        // then
        assertEquals("没有车票，取车失败", result.getMessage());
    }

    @Test
    void should_throw_exception_when_pick_up_car_given_invalid_ticket_and_the_car_not_in_the_parking_lot() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        Car existedCar = new Car();
        parkingLot.parkingCar(existedCar);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.pickUpCar(new Ticket()));
        // then
        assertEquals("没有对应车辆，取车失败", result.getMessage());
    }
}
