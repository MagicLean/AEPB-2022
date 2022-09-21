package com.example.AEPB.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void should_park_successfully_when_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 10);
        Car car = new Car("京A12345");
        // when
        Ticket ticket = parkingLot.parkingCar(car);
        // then
        List<Car> carList = parkingLot.getCarList();
        List<Ticket> ticketList = parkingLot.getTicketList();
        assertEquals(car, carList.get(0));
        assertEquals(ticket, ticketList.get(0));
        assertEquals(9, parkingLot.getRemainingSpaceCount());
    }

    @Test
    void should_failed_to_park_when_parking_car_given_valid_car_and_no_space_in_parking_lot() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 0);
        Car car = new Car("京A12345");
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.parkingCar(car));
        // then
        assertEquals("没有剩余车位，停车失败", result.getMessage());
    }

    @Test
    void should_failed_to_park_when_parking_car_given_invalid_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 1);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.parkingCar(null));
        // then
        assertEquals("没有车辆，停车失败", result.getMessage());
    }

    @Test
    void should_get_the_car_when_pick_up_car_given_valid_ticket_and_the_car_in_the_parking_lot() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Car car = new Car("京A12345");
        Ticket ticket = parkingLot.parkingCar(car);
        // when
        Car pick = parkingLot.pickUpCar(ticket);
        // then
        assertEquals(car, pick);
        assertEquals(0, parkingLot.getCarList().size());
        assertEquals(0, parkingLot.getTicketList().size());
        assertEquals(1, parkingLot.getRemainingSpaceCount());
    }

    @Test
    void should_failed_to_pick_up_when_pick_up_car_given_no_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Car car = new Car("京A12345");
        parkingLot.parkingCar(car);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.pickUpCar(null));
        // then
        assertEquals("没有车票，取车失败", result.getMessage());
    }

    @Test
    void should_failed_to_pick_up_when_pick_up_car_given_invalid_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Car car = new Car("京A12345");
        parkingLot.parkingCar(car);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.pickUpCar(new Ticket("1", 1, "1")));
        // then
        assertEquals("车票无效，取车失败", result.getMessage());
    }

    @Test
    void should_failed_to_pick_up_when_pick_up_car_given_valid_ticket_and_car_not_in_parking_lot() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Ticket ticket = new Ticket("1", 1, "1");
        parkingLot.getTicketList().add(ticket);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLot.pickUpCar(ticket));
        // then
        assertEquals("没找到车辆，取车失败", result.getMessage());
    }
}
