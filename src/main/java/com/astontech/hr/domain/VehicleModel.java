package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER) //sub elements will be saved first and
    // retrieving will get all nested subelements
    @JoinColumn(name = "VehicleModelId")
    private List<Vehicle> vehicleList;

    private String vehicleModelName;

    public VehicleModel(){}

    public VehicleModel(String vehicleModelName)
    {
        this.setVehicleModelName(vehicleModelName);
    }

    public VehicleModel(String vehicleModelName, List<Vehicle> vehicleList)
    {
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleList(vehicleList);
    }


    public String getVehicleModelName()
    {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
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

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return vehicleModelName;
    }


}
