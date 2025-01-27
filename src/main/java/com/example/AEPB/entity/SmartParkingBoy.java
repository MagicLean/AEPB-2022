package com.example.AEPB.entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SmartParkingBoy extends AbstractValetCar {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket valetParkingCar(Car car) {
        if (Objects.isNull(car)) {
            throw new RuntimeException("没有车辆，停车失败");
        }
        ParkingLot validParkingLot = getMaxRemainingSpaceCountParkingLot();
        return validParkingLot.parkingCar(car);
    }
}
