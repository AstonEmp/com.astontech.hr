package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleMakeServiceImpl implements VehicleMakeService
{

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Override
    public Iterable<VehicleMake> listAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public VehicleMake getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findOne(id);
    }

    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable) {
        return vehicleMakeRepository.save(vehicleMakeIterable);
    }

    @Override
    public void deleteVehicleMake(Integer id) {
        vehicleMakeRepository.delete(id);
    }

    @Override
    public VehicleMake findByVehicleMakeMakeName(String vehicleMakeName) {
        return vehicleMakeRepository.findByVehicleMakeMakeName(vehicleMakeName);
    }

    @Override
    public List<VehicleMake> findAllByVehicleMakeName(String vehicleMakeName) {
        return vehicleMakeRepository.findAllByVehicleMakeName(vehicleMakeName);
    }

    @Override
    public List<VehicleMake> findAllByVehicleMakeNameIgnoreCase(String vehicleMakeName) {
        return vehicleMakeRepository.findAllByVehicleMakeNameIgnoreCase(vehicleMakeName);
    }

    @Override
    public Integer countByVehicleMakeName(String vehicleMakeName) {
        return vehicleMakeRepository.countByVehicleMakeName(vehicleMakeName);
    }
}
