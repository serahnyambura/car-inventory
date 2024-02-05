package com.project.one1.carinventory;

public class Car {
    private int year;
    private String make;
    private String model;
    private String vin;
    private double mileage;
    private double cost;
    private boolean cleanRecord;
    private String imageUrl;

    public Car(int year, String make, String model, String vin, double mileage, double cost, boolean cleanRecord, String imageUrl) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.mileage = mileage;
        this.cost = cost;
        this.cleanRecord = cleanRecord;
        this.imageUrl = imageUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isCleanRecord() {
        return cleanRecord;
    }

    public void setCleanRecord(boolean cleanRecord) {
        this.cleanRecord = cleanRecord;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
