package com.astontech.hr.rest;

import com.astontech.hr.domain.Contact;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactRest
{
    private Logger log = Logger.getLogger(ContactRest.class);

    private final ContactService contactService;

    @Autowired
    public ContactRest(ContactService contactService)
    {
        this.contactService = contactService;
    }

    // Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Contact> getAll()
    {
        return contactService.findAll();
    }

    // Get by Id
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Contact getById(@PathVariable int id)
    {
        return contactService.getContactById(id);
    }

    // Save
    @RequestMapping (value = "/",method = RequestMethod.POST)
    public Contact save(@ModelAttribute("contact")Contact contact)
    //public Contact save(@RequestBody Contact contact)//for postman
    {
        return contactService.saveContact(contact);
    }

    // Delete
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id)
    {
        boolean result = false;

        try
        {
            contactService.deleteContact(id);
            return true;
        }
        catch(Exception ex)
        {
            log.info(ex);
        }
        return result;
    }



}
