package com.example.AEPB.entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SmartParkingBoy extends GraduateParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    Ticket valetParkingCar(Car car) {
        if (Objects.isNull(car)) {
            throw new RuntimeException("没有车辆，停车失败");
        }
        ParkingLot validParkingLot = getMaxRemainingSpaceCountParkingLot();
        return validParkingLot.parkingCar(car);
    }

    private ParkingLot getMaxRemainingSpaceCountParkingLot() {
        List<ParkingLot> parkingLotList = this.getParkingLotList();
        int maxRemainingSize = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            Integer remainingSpaceCount = parkingLot.getRemainingSpaceCount();
            if (remainingSpaceCount > maxRemainingSize) {
                maxRemainingSize = remainingSpaceCount;
            }
        }

        int finalMaxRemainingSize = maxRemainingSize;
        Optional<ParkingLot> optionalParkingLot = parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getRemainingSpaceCount().equals(finalMaxRemainingSize))
                .findFirst();
        if (optionalParkingLot.isPresent()) {
            return optionalParkingLot.get();
        } else {
            throw new RuntimeException("没有停车场");
        }
    }
}
