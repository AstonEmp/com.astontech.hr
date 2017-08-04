package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer>
{
    /*
custom Repository methods
 */
    // will auto generate the required code from the structure of the method name
    Vehicle findByOwnerName(String vehicleOwnerName);

    List<Vehicle> findAllByOwnerName (String vehicleOwnerName);

    List<Vehicle> findAllByOwnerNameIgnoreCase (String vehicleOwnerName);

    Integer countByOwnerName(String ownerName);
}
