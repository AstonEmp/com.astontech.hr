package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleServiceImpl implements VehicleService
{
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Iterable<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable) {
        return vehicleRepository.save(vehicleIterable);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.delete(id);
    }

    @Override
    public Vehicle findByVehicleOwnerName(String vehicleOwnerName) {
        return vehicleRepository.findByVehicleOwnerName(vehicleOwnerName);
    }

    @Override
    public List<Vehicle> findAllByVehicleOwnerName(String vehicleOwnerName) {
        return vehicleRepository.findAllByVehicleOwnerName(vehicleOwnerName);
    }

    @Override
    public List<Vehicle> findAllByVehicleOwnerNameIgnoreCase(String vehicleOwnerName) {
        return vehicleRepository.findAllByVehicleOwnerNameIgnoreCase(vehicleOwnerName);
    }

    @Override
    public Integer countByVehicleOwnerName(String vehicleOwnerName) {
        return vehicleRepository.countByVehicleOwnerName(vehicleOwnerName);
    }
}
