package com.example.AEPB.entity;

public class Ticket {
    private String id;

    private Integer parkingLotId;

    private String carPlateNumber;

    public Ticket(String id, Integer parkingLotId, String carPlateNumber) {
        this.id = id;
        this.parkingLotId = parkingLotId;
        this.carPlateNumber = carPlateNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

}
