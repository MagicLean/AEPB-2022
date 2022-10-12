package com.example.AEPB.entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractValetCar {
    protected List<ParkingLot> parkingLotList;

    private AbstractValetCar() {
    }

    public AbstractValetCar(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public Ticket valetParkingCar(Car car) {
        if (Objects.isNull(car)) {
            throw new RuntimeException("没有车辆，停车失败");
        }
        for (ParkingLot parkingLot : this.parkingLotList) {
            try {
                return parkingLot.parkingCar(car);
            } catch (Exception e) {
                // todo: log
            }
        }
        throw new RuntimeException("没有剩余车位，停车失败");
    }

    public Car valetPickUpCar(Ticket ticket) {
        if (Objects.isNull(ticket)) {
            throw new RuntimeException("没有车票，取车失败");
        }
        Optional<ParkingLot> parkingLotOptional = parkingLotList.stream().filter(p -> p.getId().equals(ticket.getParkingLotId())).findFirst();
        if (parkingLotOptional.isEmpty()) {
            throw new RuntimeException("车票无效，取车失败");
        }
        ParkingLot parkingLot = parkingLotOptional.get();
        return parkingLot.pickUpCar(ticket);
    }

    protected ParkingLot getMaxRemainingSpaceCountParkingLot() {
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
