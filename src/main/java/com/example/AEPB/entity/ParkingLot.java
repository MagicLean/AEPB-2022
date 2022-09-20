package com.example.AEPB.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {
    private Integer spaceCount;

    private Map<Ticket, Car> ticketToCarMap;

    public ParkingLot(Integer spaceCount) {
        this.spaceCount = spaceCount;
        this.ticketToCarMap = new HashMap<>();
    }

    public Integer getRemainingSpaceCount() {
        return this.spaceCount - this.ticketToCarMap.size();
    }

    public Ticket parkingCar(Car car) {
        if (Objects.isNull(car)) {
            throw new RuntimeException("没有车辆，停车失败");
        }
        // 判断车位是否有剩余
        if (getRemainingSpaceCount() <= 0) {
            throw new RuntimeException("没有剩余车位，停车失败");
        }
        // 生成ticket，并记录车票和车辆信息
        Ticket newTicket = new Ticket();
        ticketToCarMap.put(newTicket, car);
        return newTicket;
    }

    public Car pickUpCar(Ticket ticket) {
        if (Objects.isNull(ticket)) {
            throw new RuntimeException("没有车票，取车失败");
        }
        Car car = ticketToCarMap.get(ticket);
        if (Objects.isNull(car)) {
            throw new RuntimeException("没有对应车辆，取车失败");
        }
        ticketToCarMap.remove(ticket);
        return car;
    }
}
