package com.example.AEPB.service;

import com.example.AEPB.entity.Car;
import com.example.AEPB.entity.ParkingLot;
import com.example.AEPB.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class ParkingLotManagementService {
    public static final Map<String, Car> carPlateNumberKeyToCarMap = new HashMap<>();

    public static final Map<String, Ticket> carIdToTicketMap = new HashMap<>();

    public static final ParkingLot parkingLot = new ParkingLot(100, 100);

    Ticket parkingCar(Car car) {
        String carPlateNumber = car.getCarPlateNumber();
        Car existedCar = carPlateNumberKeyToCarMap.get(carPlateNumber);
        // 记录车辆信息
        if (Objects.isNull(existedCar)) {
            car.setId(UUID.randomUUID().toString());
            carPlateNumberKeyToCarMap.put(carPlateNumber, car);
        }
        // 判断车位是否有剩余
        if (parkingLot.getRemainingSpaceCount() <= 0) {
            throw new RuntimeException("没有剩余车位");
        }
        // 生成ticket，并记录
        Ticket newTicket = new Ticket(UUID.randomUUID().toString(), car.getId(), true);
        carIdToTicketMap.put(newTicket.getCarId(), newTicket);
        parkingLot.setRemainingSpaceCount(parkingLot.getRemainingSpaceCount() - 1);
        return newTicket;
    }

    Ticket pickUpCar(Ticket ticket) {
        if (Objects.isNull(ticket)) {
            throw new RuntimeException("没有车票");
        }
        String carId = ticket.getCarId();
        Ticket existedTicket = carIdToTicketMap.get(carId);
        if (Objects.isNull(existedTicket)) {
            throw new RuntimeException("车票无效——伪造车票");
        }
        if (!existedTicket.getEnabled()) {
            throw new RuntimeException("车票无效——过期车票");
        }
        existedTicket.setEnabled(false);
        parkingLot.setRemainingSpaceCount(parkingLot.getRemainingSpaceCount() + 1);
        return existedTicket;
    }
}
