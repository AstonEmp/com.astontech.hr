package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer>
{
    /*
custom Repository methods
 */
    // will auto generate the required code from the structure of the method name
    VehicleModel findByVehicleModelName(String vehicleModelName);

    List<VehicleModel> findAllByVehicleModelName (String vehicleModelName);

    List<VehicleModel> findAllByVehicleModelNameIgnoreCase (String vehicleModelName);

    Integer countByVehicleModelName(String vehicleModelName);
}
