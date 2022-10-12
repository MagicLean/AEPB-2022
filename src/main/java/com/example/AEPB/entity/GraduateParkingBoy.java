package com.example.AEPB.entity;

import java.util.List;

public class GraduateParkingBoy extends AbstractValetCar{

    public GraduateParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        this.parkingLotList = parkingLotList;
    }
}
