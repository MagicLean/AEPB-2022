package com.example.AEPB.entity;

public class Ticket {
    private String id;

    private String carId;

    private Boolean enabled;

    public Ticket(String id, String carId, Boolean enabled) {
        this.id = id;
        this.carId = carId;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
