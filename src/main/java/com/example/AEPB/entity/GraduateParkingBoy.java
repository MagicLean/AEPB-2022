package com.example.AEPB.entity;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GraduateParkingBoy {
    private List<Integer> parkingLotIdList;

    List<ParkingLot> init() {
        ParkingLot parkingLot = new ParkingLot(1, 10);
        ParkingLot parkingLot2 = new ParkingLot(2, 12);
        parkingLotIdList = List.of(1, 2);
        return List.of(parkingLot, parkingLot2);
    }

    Ticket valetParkingCar(Car car) {
        List<ParkingLot> parkingLotList = init();
        Map<Integer, ParkingLot> idToParkingLotMap = parkingLotList.stream().collect(Collectors.toMap(ParkingLot::getId, Function.identity()));
        for (Integer parkingLotId : parkingLotIdList) {
            try {
                ParkingLot parkingLot = idToParkingLotMap.get(parkingLotId);
                return parkingLot.parkingCar(car);
            } catch (Exception e) {
                // todo: log
            }
        }
        throw new RuntimeException("停车失败");
    }

    Car valetPickUpCar(Ticket ticket) {
        List<ParkingLot> parkingLotList = init();
        Map<Integer, ParkingLot> idToParkingLotMap = parkingLotList.stream().collect(Collectors.toMap(ParkingLot::getId, Function.identity()));
        Optional<Integer> idOptional = parkingLotIdList.stream().filter(parkingLotId -> parkingLotId.equals(ticket.getParkingLotId())).findFirst();
        if (idOptional.isEmpty()) {
            throw new RuntimeException("取车失败");
        }
        Integer parkingLotId = idOptional.get();
        ParkingLot parkingLot = idToParkingLotMap.get(parkingLotId);
        return parkingLot.pickUpCar(ticket);
    }
}
