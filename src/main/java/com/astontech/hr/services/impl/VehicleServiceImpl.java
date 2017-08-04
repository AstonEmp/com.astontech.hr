package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Vehicle findByOwnerName(String ownerName) {
        return vehicleRepository.findByOwnerName(ownerName);
    }

    @Override
    public List<Vehicle> findAllByOwnerName(String ownerName) {
        return vehicleRepository.findAllByOwnerName(ownerName);
    }

    @Override
    public List<Vehicle> findAllByOwnerNameIgnoreCase(String ownerName) {
        return vehicleRepository.findAllByOwnerNameIgnoreCase(ownerName);
    }

    @Override
    public Integer countByOwnerName(String ownerName) {
        return vehicleRepository.countByOwnerName(ownerName);
    }
}
