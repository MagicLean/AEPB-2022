package com.example.AEPB.entity;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GraduateParkingBoy {

    private List<ParkingLot> parkingLotList;

    public GraduateParkingBoy() {
        init();
    }

    void init() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        ParkingLot parkingLot2 = new ParkingLot(2, 1);
        this.parkingLotList = List.of(parkingLot, parkingLot2);
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    Ticket valetParkingCar(Car car) {
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

    Car valetPickUpCar(Ticket ticket) {
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
}
