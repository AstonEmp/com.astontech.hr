//package services;
//
//import com.astontech.hr.Application;
//import com.astontech.hr.domain.Contact;
//import com.astontech.hr.services.ContactService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)//sets up the spring junit class when tests are run
//@SpringApplicationConfiguration(classes = {Application.class}) // read the repository configuration
//@WebAppConfiguration
//public class ContactServiceTest
//{
//    @Autowired
//    private ContactService contactService;
//
//    @Test
//    public void contactServiceSaveTest()
//    {
//        Contact contact = new Contact();
//
//        contact.setEmailAddress("eric@outlook.com");
//
//        assertNull(contact.getId());
//        contactService.saveContact(contact);
//        assertNotNull(contact.getId());
//
//        //fetch
//        Contact fetchedContact = contactService.getContactById(contact.getId());
//        assertNotNull(fetchedContact);
//        assertEquals(contact.getId(),fetchedContact.getId());
//
//        //update
//        fetchedContact.setEmailAddress("test@outlook.com");
//        contactService.saveContact(fetchedContact);
//
//        Contact updatedContact = contactService.getContactById(fetchedContact.getId());
//        assertEquals("test@outlook.com", updatedContact.getEmailAddress());
//    }
//}
