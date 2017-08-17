package com.astontech.hr.repositories;

import com.astontech.hr.domain.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer>
{
    List<Contact> findAll();

    List<Contact> findAllByEmailAddressIgnoreCase (String emailAddress);


}
