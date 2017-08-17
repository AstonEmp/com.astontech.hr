package com.astontech.hr.repositories;

import com.astontech.hr.domain.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer>
{
    List<Address> findAll();

    List<Address> findAllByStateIgnoreCase (String state);
}
