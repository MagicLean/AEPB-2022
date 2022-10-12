package com.example.AEPB.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingRobotTest {

    @Test
    void should_park_car_in_parking_lot_2_when_parking_robot_valet_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot_2_more_than_parking_lot_1() {
        // given
        ParkingRobot parkingRobot = new ParkingRobot(List.of(new ParkingLot(1, 1), new ParkingLot(2, 2)));
        // when
        Car car = new Car("京A12345");
        Ticket ticket = parkingRobot.valetParkingCar(car);
        // then
        assertNotNull(ticket);
        ParkingLot parkingLot = parkingRobot.getParkingLotList().get(1);
        assertEquals(ticket, parkingLot.getTicketList().get(0));
        assertEquals(car, parkingLot.getCarList().get(0));
    }

    @Test
    void should_park_car_in_parking_lot_1_when_parking_robot_valet_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot_2_equals_parking_lot_1() {
        // given
        ParkingRobot parkingRobot = new ParkingRobot(List.of(new ParkingLot(1, 1), new ParkingLot(2, 1)));
        // when
        Car car = new Car("京A12345");
        Ticket ticket = parkingRobot.valetParkingCar(car);
        // then
        assertNotNull(ticket);
        ParkingLot parkingLot = parkingRobot.getParkingLotList().get(0);
        assertEquals(ticket, parkingLot.getTicketList().get(0));
        assertEquals(car, parkingLot.getCarList().get(0));
    }

    @Test
    void should_pick_up_failed_when_parking_robot_valet_pick_up_car_given_valid_ticket_and_car_in_the_parking_lot() {
        ParkingRobot parkingRobot = new ParkingRobot(List.of(new ParkingLot(1, 1), new ParkingLot(2, 1)));
        Car car = new Car("京A12345");
        Ticket ticket = parkingRobot.valetParkingCar(car);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> parkingRobot.valetPickUpCar(ticket));

        assertEquals("功能暂时未开通", exception.getMessage());
    }
}
