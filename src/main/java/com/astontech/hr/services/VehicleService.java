package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;

import java.util.List;

public interface VehicleService
{
    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable);

    void deleteVehicle(Integer id);

    /*
    custom Repository methods
     */
    // will auto generate the required code from the structure of the method name
    Vehicle findByVehicleOwnerName(String vehicleOwnerName);

    List<Vehicle> findAllByVehicleOwnerName (String vehicleOwnerName);

    List<Vehicle> findAllByVehicleOwnerNameIgnoreCase (String vehicleOwnerName);

    Integer countByVehicleOwnerName(String vehicleOwnerName);
}
