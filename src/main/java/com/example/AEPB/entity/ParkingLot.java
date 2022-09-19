package com.example.AEPB.entity;

public class ParkingLot {
    private Integer spaceCount;

    private Integer remainingSpaceCount;


    public ParkingLot(Integer spaceCount, Integer remainingSpaceCount) {
        this.spaceCount = spaceCount;
        this.remainingSpaceCount = remainingSpaceCount;
    }

    public Integer getSpaceCount() {
        return spaceCount;
    }

    public void setSpaceCount(Integer spaceCount) {
        this.spaceCount = spaceCount;
    }

    public Integer getRemainingSpaceCount() {
        return remainingSpaceCount;
    }

    public void setRemainingSpaceCount(Integer remainingSpaceCount) {
        this.remainingSpaceCount = remainingSpaceCount;
    }
}
