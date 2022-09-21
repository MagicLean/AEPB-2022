package com.example.AEPB.entity;

import java.util.List;
import java.util.Objects;

public class GraduateParkingBoy {
    private List<ParkingLot> parkingLotList;

    public GraduateParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    Ticket valetParkingCar(Car car) {
        for (ParkingLot parkingLot : parkingLotList) {
            Ticket ticket = parkingLot.parkingCar(car);
            if (Objects.nonNull(ticket)) {
                return ticket;
            }
        }
        return null;
    }

    Car valetPickUpCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLotList) {
            Car car = parkingLot.pickUpCar(ticket);
            if (Objects.nonNull(car)) {
                return car;
            }
        }
        return null;
    }

}
