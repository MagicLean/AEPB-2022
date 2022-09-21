package com.example.AEPB.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraduateParkingBoyTest {
    @Test
    void should_get_ticket_when_valet_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot() {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLotList = List.of(new ParkingLot(0), new ParkingLot(20));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        // when
        Ticket ticket = graduateParkingBoy.valetParkingCar(car);
        // then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_valet_parking_car_given_valid_car_and_no_space_in_parking_lot() {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLotList = List.of(new ParkingLot(0), new ParkingLot(0));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        // when
        Ticket ticket = graduateParkingBoy.valetParkingCar(car);
        // then
        assertNull(ticket);
    }

    @Test
    void should_throw_exception_when_valet_parking_car_given_no_car() {
        // given
        List<ParkingLot> parkingLotList = List.of(new ParkingLot(1), new ParkingLot(1));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> graduateParkingBoy.valetParkingCar(null));
        // then
        assertEquals("没有车辆，停车失败", result.getMessage());
    }

    @Test
    void should_get_the_car_when_valet_pick_up_car_given_valid_ticket_and_the_car_in_the_parking_lot() {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLotList = List.of(new ParkingLot(0), new ParkingLot(1));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        Ticket ticket = graduateParkingBoy.valetParkingCar(car);
        // when
        Car pickUpCar = graduateParkingBoy.valetPickUpCar(ticket);
        // then
        assertEquals(car, pickUpCar);
    }

    @Test
    void should_return_null_when_valet_pick_up_car_given_valid_ticket_and_the_car_not_in_the_parking_lot() {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLotList = List.of(new ParkingLot(0), new ParkingLot(1));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        graduateParkingBoy.valetParkingCar(car);
        // when
        Car pickUpCar = graduateParkingBoy.valetPickUpCar(new Ticket());
        // then
        assertNull(pickUpCar);
    }

    @Test
    void should_throw_exception_when_valet_pick_up_car_given_no_ticket() {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLotList = List.of(new ParkingLot(0), new ParkingLot(1));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        graduateParkingBoy.valetParkingCar(car);
        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> graduateParkingBoy.valetPickUpCar(null));
        // then
        assertEquals("没有车票，取车失败", result.getMessage());
    }
}
