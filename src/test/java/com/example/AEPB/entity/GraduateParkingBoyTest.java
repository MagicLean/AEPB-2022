package com.example.AEPB.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GraduateParkingBoyTest {

    @Test
    void should_park_successfully_when_valet_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot() {
        List<ParkingLot> parkingLotList = initParkingLotList();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);

        Ticket ticket = graduateParkingBoy.valetParkingCar(new Car("京A12345"));

        assertNotNull(ticket);
    }

    private List<ParkingLot> initParkingLotList() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        ParkingLot parkingLot2 = new ParkingLot(2, 1);
        return List.of(parkingLot, parkingLot2);
    }

    @Test
    void should_park_failed_when_valet_parking_car_given_valid_car_and_no_space_in_all_parking_lots() {
        List<ParkingLot> parkingLotList = initParkingLotList();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        graduateParkingBoy.valetParkingCar(new Car("京A12345"));
        graduateParkingBoy.valetParkingCar(new Car("京A11111"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> graduateParkingBoy.valetParkingCar(new Car("京A22222")));

        assertEquals("没有剩余车位，停车失败", exception.getMessage());
    }

    @Test
    void should_park_failed_when_valet_parking_car_given_no_car() {
        List<ParkingLot> parkingLotList = initParkingLotList();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> graduateParkingBoy.valetParkingCar(null));

        assertEquals("没有车辆，停车失败", exception.getMessage());
    }

    @Test
    void should_pick_up_successfully_when_valet_pick_up_car_given_valid_ticket_and_car_in_the_parking_lot() {
        List<ParkingLot> parkingLotList = initParkingLotList();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        graduateParkingBoy.valetParkingCar(new Car("京A12345"));
        Ticket ticket = graduateParkingBoy.valetParkingCar(new Car("京A11111"));

        Car pickUpCar = graduateParkingBoy.valetPickUpCar(ticket);

        assertNotNull(pickUpCar);
    }

    @Test
    void should_pick_up_failed_when_valet_pick_up_car_given_no_ticket() {
        List<ParkingLot> parkingLotList = initParkingLotList();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        graduateParkingBoy.valetParkingCar(new Car("京A12345"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> graduateParkingBoy.valetPickUpCar(null));

        assertEquals("没有车票，取车失败", exception.getMessage());
    }

    @Test
    void should_pick_up_failed_when_valet_pick_up_car_given_fake_ticket() {
        List<ParkingLot> parkingLotList = initParkingLotList();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        graduateParkingBoy.valetParkingCar(new Car("京A12345"));
        Ticket ticket = graduateParkingBoy.valetParkingCar(new Car("京A11111"));
        graduateParkingBoy.valetPickUpCar(ticket);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> graduateParkingBoy.valetPickUpCar(ticket));

        assertEquals("车票无效，取车失败", exception.getMessage());
    }

    @Test
    void should_pick_up_failed_when_valet_pick_up_car_given_valid_ticket_and_car_not_in_parking_lot() {
        List<ParkingLot> parkingLotList = initParkingLotList();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLotList);
        Ticket ticket = new Ticket("1", 2, "1");
        graduateParkingBoy.getParkingLotList().get(1).getTicketList().add(ticket);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> graduateParkingBoy.valetPickUpCar(ticket));

        assertEquals("没找到车辆，取车失败", exception.getMessage());
    }

}
