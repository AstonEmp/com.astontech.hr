package com.astontech.hr.services;

import com.astontech.hr.domain.Contact;

import java.util.List;

public interface ContactService
{
    Contact getContactById(Integer id);

    Contact saveContact(Contact contact);

    void deleteContact(Integer id);

    Iterable<Contact> saveContactList(Iterable<Contact> contactIterable);

    void deleteAll();


    // will auto generate the required code from the structure of the method name
    /*
    custom repository methods
     */
    List<Contact> findAll();

    List<Contact> findAllByEmailAddressIgnoreCase (String emailAddress);
}
