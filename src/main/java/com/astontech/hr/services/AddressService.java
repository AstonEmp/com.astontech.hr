package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

import java.util.List;

public interface AddressService
{
    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    void deleteAddress(Integer id);

    Iterable<Address> saveAddressList(Iterable<Address> addressIterable);

    void deleteAll();
    // will auto generate the required code from the structure of the method name
    /*
    custom repository methods
     */
    List<Address> findAll();

    List<Address> findAllByStateIgnoreCase (String state);
}
