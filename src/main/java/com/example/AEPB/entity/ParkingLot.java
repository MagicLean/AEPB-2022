package com.example.AEPB.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ParkingLot {

    private Integer id;
    private Integer spaceCount;

    private final List<Car> carList;

    private final List<Ticket> ticketList;

    public ParkingLot(Integer id, Integer spaceCount) {
        this.id = id;
        this.spaceCount = spaceCount;
        this.carList = new ArrayList<>();
        this.ticketList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Integer getRemainingSpaceCount() {
        return this.spaceCount - this.carList.size();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    Ticket parkingCar(Car car) {
        if (Objects.isNull(car)) {
            throw new RuntimeException("没有车辆，停车失败");
        }
        // 判断车位是否有剩余
        if (getRemainingSpaceCount() <= 0) {
            throw new RuntimeException("没有剩余车位，停车失败");
        }
        // 生成ticket，并记录车辆和车票信息
        Ticket newTicket = new Ticket(UUID.randomUUID().toString(), this.id, car.getCarPlateNumber());
        this.carList.add(car);
        this.ticketList.add(newTicket);
        return newTicket;
    }

    Car pickUpCar(Ticket ticket) {
        if (Objects.isNull(ticket)) {
            throw new RuntimeException("没有车票，取车失败");
        }
        Optional<Ticket> existedTicketOptional = ticketList.stream().filter(t -> t.getId().equals(ticket.getId())).findFirst();
        if (existedTicketOptional.isEmpty()) {
            throw new RuntimeException("车票无效，取车失败");
        }
        Ticket existedTicket = existedTicketOptional.get();
        String carPlateNumber = existedTicket.getCarPlateNumber();
        Optional<Car> carOptional = carList.stream().filter(car -> car.getCarPlateNumber().equals(carPlateNumber)).findFirst();
        if (carOptional.isEmpty()) {
            throw new RuntimeException("没找到车辆，取车失败");
        }
        Car car = carOptional.get();
        carList.remove(car);
        ticketList.remove(existedTicket);
        return car;
    }
}
