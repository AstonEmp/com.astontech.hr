package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class Vehicle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Version
    private Integer version;

    private int year;
    private String VIN;
    private String color;
    private String licensePlate;
    private String ownerName;

    public Vehicle (){}

    public Vehicle(String ownerName, int year, String VIN, String color, String licensePlate) {
        this.year = year;
        this.VIN = VIN;
        this.color = color;
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
