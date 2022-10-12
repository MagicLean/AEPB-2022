package com.example.AEPB.entity;

import java.util.List;
import java.util.Objects;

public class ParkingRobot extends AbstractValetCar{

    public ParkingRobot(List<ParkingLot> parkingLotList) {
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

    @Override
    public Car valetPickUpCar(Ticket ticket) {
        throw new RuntimeException("功能暂时未开通");
    }
}
