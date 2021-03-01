package com.jupiter.car.hire.beans;

import com.jupiter.car.hire.enums.VehicleType;

public class Vehicle {
    private long vehicleId;
    private VehicleType vehicleType;
    private String registration;
    private long engineSize;
    private double pricePerDay;

    public Vehicle(long vehicleId, VehicleType vehicleType,  String registration, long engineSize, double pricePerDay) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;

        this.registration = registration;
        this.engineSize = engineSize;
        this.pricePerDay = pricePerDay;
    }

    public Vehicle(VehicleType vehicleType,  String registration, long engineSize, double pricePerDay) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;

        this.registration = registration;
        this.engineSize = engineSize;
        this.pricePerDay = pricePerDay;
    }


    public Vehicle(){

    }

    /**
     * ritrieves vehicle id
     * @return
     */
    public long getVehicleId() {
        return vehicleId;
    }

    /**
     * vehicle id to
     * be set
     * @param vehicleId
     */
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * retrieves vehicle
     * type
     * @return
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * Vehicle type      *
     * to be set
     * @param vehicleType
     */
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * retrieves vehicle
     * registration number
     * @return
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * vehicle regostration number to be set
     * @param registration
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    /**
     * retrieve Vehicle
     * engin size
     * @return
     */
    public long getEngineSize() {
        return engineSize;
    }

    /**
     * engine side to
     * be set
     * @param engineSize
     */
    public void setEngineSize(long engineSize) {
        this.engineSize = engineSize;
    }

    /**
     * retrieves rental
     * price per day
     * @return
     */
    public double getPricePerDay() {
        return pricePerDay;
    }

    /**
     * rental price per day to be set
     * @param pricePerDay
     */
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
