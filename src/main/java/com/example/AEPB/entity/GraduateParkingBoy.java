package com.example.AEPB.entity;

import java.util.List;

public class GraduateParkingBoy {
    private List<ParkingLot> parkingLotList;

    public GraduateParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    Ticket valetParkingCar(Car car) {
        for (ParkingLot parkingLot : parkingLotList) {
            try {
                return parkingLot.parkingCar(car);
            } catch (Exception e) {

            }
        }
        throw new RuntimeException("停车失败");
    }

    Car valetPickUpCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLotList) {
            try {
                parkingLot.pickUpCar(ticket);
            } catch (Exception e) {

            }
        }
        throw new RuntimeException("取车失败");
    }

}
