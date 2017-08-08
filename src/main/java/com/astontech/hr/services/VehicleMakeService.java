package com.astontech.hr.services;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.VehicleMake;

import java.util.List;

public interface VehicleMakeService
{
    Iterable<VehicleMake> listAllVehicleMakes();

    VehicleMake getVehicleMakeById(Integer id);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    void deleteVehicleMake(Integer id);

    /*
    custom Repository methods
     */
    // will auto generate the required code from the structure of the method name
    VehicleMake findByVehicleMakeName(String vehicleMakeName);

    List<VehicleMake> findAllByVehicleMakeName (String vehicleMakeName);

    List<VehicleMake> findAllByVehicleMakeNameIgnoreCase (String vehicleMakeName);

    Integer countByVehicleMakeName(String vehicleMakeName);

    VehicleMake updateVehicleMake(VehicleVO vehicleVO, Integer makeId, Integer modelId, Integer vehicleId);

    VehicleMake iterateThroughMakeListCheckifExistsSave(VehicleVO vehicleVO);
}
