package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleMakeRepository extends CrudRepository<VehicleMake,Integer>
{
    /*
custom Repository methods
 */
    // will auto generate the required code from the structure of the method name
    VehicleMake findByVehicleMakeMakeName(String vehicleMakeName);

    List<VehicleMake> findAllByVehicleMakeName (String vehicleMakeName);

    List<VehicleMake> findAllByVehicleMakeNameIgnoreCase (String vehicleMakeName);

    Integer countByVehicleMakeName(String vehicleMakeName);
}
