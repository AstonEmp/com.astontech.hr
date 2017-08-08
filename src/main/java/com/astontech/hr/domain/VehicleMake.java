package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleMakeId")
    private Integer id;

    @Version
    private Integer version;


    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER) //sub elements will be saved first and
    // retrieving will get all nested subelements
    @JoinColumn(name = "VehicleMakeId")
    private List<VehicleModel> vehicleModelList;

    private String vehicleMakeName;

    public VehicleMake(){}

    public VehicleMake(String vehicleMakeName)
    {
        this.vehicleMakeName = vehicleMakeName;
    }

    public VehicleMake(List<VehicleModel> vehicleModelList, String vehicleMakeName)
    {
        this.setVehicleModelList(vehicleModelList);
        this.setVehicleMakeName(vehicleMakeName);
    }

    public String getVehicleMakeName()
    {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
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

    public List<VehicleModel> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }

    @Override
    public String toString() {
        return vehicleMakeName;
    }
}
